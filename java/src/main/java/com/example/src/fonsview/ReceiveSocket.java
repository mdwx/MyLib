package com.example.src.fonsview;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ReceiveSocket extends UdpSocket
{
	private PacketCallBack packetCallBack;
	private ParseThread _parseThread;
	private LinkedBlockingQueue<DatagramPacket> _receiveQueue;
	private int _myPort;
	private int _queueMaxSize = 1000;
	private boolean STOP;
	public ReceiveSocket() throws SocketException {
		super();
		ReceiveSocketinit();
	}
	public ReceiveSocket(int port) throws SocketException
	{
		super(port);
	    _myPort = port;
		ReceiveSocketinit();
	}
	public ReceiveSocket(int port,PacketCallBack packetCallBack) throws SocketException
	{
		super(port);
		_myPort = port;
		this.packetCallBack = packetCallBack;
		ReceiveSocketinit();
	}
	private void ReceiveSocketinit(){
		_receiveQueue =new LinkedBlockingQueue<DatagramPacket>(_queueMaxSize);
		_receiveQueue.clear();
		_parseThread = new ParseThread();
		STOP = false;
	}
	public boolean isStop(){
		return  STOP;
	}
	public void setPacketCallBack(PacketCallBack packetCallBack){
		this.packetCallBack = packetCallBack;
	}
	private class ParseThread extends Thread
	{
		public ParseThread()
		{
			super("ParseThread");
			setDaemon(true);
		}

		public void run()
		{
			while (!STOP) {
				try {
					do{
						DatagramPacket receivePacket = _receiveQueue.poll(2000, TimeUnit.MILLISECONDS);
						if(receivePacket != null){
							ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(receivePacket.getData());
							DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
	
							int packetStart = dataInputStream.readInt();
	
							if (packetStart != START_ID) {
								System.out.println("Received faulty packet start");
								sendReqPacket(receivePacket.getAddress(), receivePacket.getPort(), NAK_ID, -1);
								break;
							}
							int packetType = dataInputStream.readInt();
							int packetIndex = dataInputStream.readInt();
	
							if (packetType == PKT_ID) {
	
							} else if (packetType == MESSAGE_ID) {
								sendReqPacket(receivePacket.getAddress(), receivePacket.getPort(), ACK_ID, packetIndex);
								STOP = true;
								continue;
							} else if (packetType == UDP_END_ID) {
								sendReqPacket(receivePacket.getAddress(), receivePacket.getPort(), ACK_ID, packetIndex);
								STOP = true;
								break;
							} else {
								System.out.println("Received unknown type");
								sendReqPacket(receivePacket.getAddress(), receivePacket.getPort(), NAK_ID, packetIndex);
								break;
							}
	
							if (packetIndex < -1) {
								System.out.println("Received wrong packet index");
								sendReqPacket(receivePacket.getAddress(), receivePacket.getPort(), NAK_ID, packetIndex);
								break;
							}
	
							int packetLength = dataInputStream.readInt();
	
							byte[] sendAddr = new byte[16];
							dataInputStream.readFully(sendAddr);
	
							int packetsendToPort = dataInputStream.readInt();
	
							if (packetLength > 0) {
								try {
									byte[] packetData = new byte[packetLength];
									dataInputStream.readFully(packetData, 0, packetLength);
	
									packetCallBack.CallBack(packetCallBack.getParam(), new PackFormat(packetData, packetData.length, packetIndex, packetType, new String(sendAddr), packetsendToPort, START_ID));
									sendReqPacket(receivePacket.getAddress(), receivePacket.getPort(), ACK_ID, packetIndex);
								} catch (EOFException e) {
									e.printStackTrace();
									}
								}
							}
						}while(_receiveQueue.size() > 0);
					}catch(IOException e){
					System.out.println("Data Input Stream readError");
					e.printStackTrace();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
	public void start()
	{
		int Timecou=0;
		_parseThread.start();
		System.out.println("Socket receiveData Start...");	
			while (!STOP) {
				try {
					byte[] receiveData = new byte[65536];
					DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
						receive(receivePacket);
						_receiveQueue.put(receivePacket);
						if(Timecou>0)Timecou--;
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (IOException e) {
					Timecou++;
					if(Timecou > 10){
						STOP = true;
					}
				}			
			}
			System.out.println("Socket receiveData over");	
	}

	public void Close() {
		STOP = true;
		close();
	}
}