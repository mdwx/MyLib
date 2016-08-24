package com.example.src.RingBuffer;

/**
 *UDPClien2
 *@author Winty wintys@gmail.com
 *@version 2008-12-15
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
class UDPWavefRecv{
	
	private DatagramSocket client;
	private DatagramPacket recvPacket;
	private byte[] Buf;
	private int size = 1024;
	
	public UDPWavefRecv(int port,int timeout) {

		try {
			client = new DatagramSocket(port);
			client.setSoTimeout(timeout);
			Buf = new byte[size];
			recvPacket = new DatagramPacket(Buf , Buf.length); 
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public int receive() {
		
		try {
			client.receive(recvPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return -1;
		}
		return recvPacket.getLength();
	}
	
	public DatagramPacket getrecvPacket(){
		
		return recvPacket;
	}

	public void close(){
		   client.close();
	}
}
