package com.example.src.fonsview;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Arales on 2016/7/28.
 * E_mail :  xhys01@163.com
 * Description :
 */
public class SendSocket extends UdpSocket {
    private InetAddress address;
    private int _Desport;
    private LinkedBlockingQueue<PackFormat> _sendQueue;
    private int _queueMaxSize = 100;
    private FlushThread _flushThread;
    private boolean IsRuning = true;

    PacketCallBack packetCallBack;

    public SendSocket() throws SocketException {
        super();
        PeerInit();
    }
    public SendSocket(int port) throws SocketException
    {
        super(port);
        PeerInit();
    }
    private void PeerInit()
    {
        _sendQueue =new LinkedBlockingQueue<PackFormat>(_queueMaxSize);
        _sendQueue.clear();

        _flushThread = new FlushThread();
    }
    public void setDestnation( InetAddress addr, int _Desport)
    {
        this.address = addr;
        this._Desport = _Desport;
    }

    public void setDestnation( String addr, int _Desport) throws UnknownHostException {
        this.address = InetAddress.getByName(addr);
        this._Desport = _Desport;
    }

    public void sendStart(){
    	IsRuning = true;
        _flushThread.start();
    }

    public void enqueue(PackFormat data) throws InterruptedException {
        _sendQueue.put(data);
    }

    int flushQueue() throws IOException
    {
        PackFormat parket = _sendQueue.peek();
        sendPacket(address, _Desport, parket.getDataTpye(), parket.getDataSequence(), parket.getData().length, parket.getSendToAddr(),parket.getSendToPort(),parket.getData());
        return parket.getDataSequence();
    }

    public void setPacketCallBack(PacketCallBack packetCallBack){
        this.packetCallBack = packetCallBack;
    }   

    private class FlushThread extends Thread
    {
        public FlushThread()
        {
            super("LocalHttpServer");
            setDaemon(true);
        }

        public void run()
        {
            int Time_count = 0;         
            try
            {
            	System.out.println("Send Thread is runing!!");
                do
                {
                    try
                    {
                    	if(_sendQueue.size() <= 0){
                    		Thread.sleep(500);
                    	}
                        while (_sendQueue.size() > 0)
                        {
                            flushQueue();

                            byte[] receiveData = new byte[1024];
                            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
 
                            setSoTimeout(CLIENT_RECV_TIMEOUT);
                            receive(receivePacket);
                            setSoTimeout(0);

                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(receiveData);
                            DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);

                            int startId = dataInputStream.readInt();

                            if (startId != START_ID)
                            {
                                System.out.println("Received faulty packet: " + startId + ", size: " + dataInputStream.available());
                                break;
                            }

                            int packetType = dataInputStream.readInt();

                            if (packetType == NAK_ID)
                            {
                                System.out.println("Received NAK");
                                break;
                            }
                            else if (packetType != ACK_ID)
                            {
                                System.out.println("Received unknown response type"+packetType);
                                break;
                            }
                            int packetSequence = dataInputStream.readInt();
                            if(packetSequence < -1){
                                System.out.println("Received packetSequence Error;");
                            }
                            _sendQueue.poll();
                            if(Time_count > 0) {
                                Time_count--;
                            }
                        }
                    }catch (SocketTimeoutException e)
                    {
                        System.out.println("Timed out..."+ Time_count);
                        Time_count++;
                        if(Time_count%3 == 0){
                        	_sendQueue.poll();
                        }
                        if(Time_count > 10){
                        	close();
                            return;
                        }
                        continue;
                    }catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    
                }while (IsRuning);
                close();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println("Send Thread is over!!");
        }
    }

	public void Close() {
		// TODO Auto-generated method stub
		if(_sendQueue.size() > 0){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}			
		IsRuning = false;		
	}
}
