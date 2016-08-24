package com.example.src.RingBuffer;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		UDPWavefRecv server = new UDPWavefRecv(9527, 1000); 
		RingBuffer Buffer = new RingBuffer();
		int len = 0;
		byte[] mwaveform = new byte[26];
		int i = 0;
		new Thread(new Runnable() {
			@Override
			public void run() {
				DatagramSocket send = null;
				try {
					send = new DatagramSocket();
				} catch (SocketException e) {
					e.printStackTrace();
				}
				DatagramPacket Packet;
				String str="This is test!";
				byte Buf[] = str.getBytes();
				while(true){
					try {
						Packet = new DatagramPacket(Buf ,Buf.length, InetAddress.getByName("127.0.0.1"),9527);
						send.send(Packet);
						Thread.sleep(100);
					} catch (IOException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();

		while(i < 1000){
			if((len = server.receive()) > 0 ){
	
				Buffer.insert(server.getrecvPacket().getData(), len);
				if(i%2 == 0) {
					if (Buffer.read(mwaveform) > 0) {
						Buffer.pop(mwaveform.length);
						String recvStr = new String(mwaveform);
						System.out.println(Buffer.size() + ":" + recvStr);
					}
				}
			}
			i++;
		}
	}
}
