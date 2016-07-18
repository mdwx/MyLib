package com.example.src.TCP_UDP;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClien {
	 public static void main(String[] args)throws IOException{
	        DatagramSocket client = new DatagramSocket();

	        String sendStr = "Hello! I'm Client";
	        byte[] sendBuf;
	        sendBuf = sendStr.getBytes();
	        InetAddress addr = InetAddress.getByName("127.0.0.1");
	        int port = 8888;
	        DatagramPacket sendPacket 
	            = new DatagramPacket(sendBuf ,sendBuf.length , addr , port);
	        sendPacket.setData(sendBuf);
			client.send(sendPacket);

	        byte[] recvBuf = new byte[4*1024];
	        DatagramPacket recvPacket = new DatagramPacket(recvBuf , recvBuf.length);
			File file = new File("E:\\New.mkv");

			if(!file.exists())
			{
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		 client.setSoTimeout(15000);
			 FileOutputStream outputStream = new FileOutputStream(file);
		 try {
			 while (true) {

				 client.receive(recvPacket);

				 outputStream.write(recvPacket.getData(), 0, recvPacket.getLength());

			 }
		 }catch(IOException e){
				 client.close();
			 }
		 }
	 }
