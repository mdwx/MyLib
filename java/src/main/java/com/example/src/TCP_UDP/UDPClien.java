package com.example.src.TCP_UDP;

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
	        int port = 9527;
	        DatagramPacket sendPacket 
	            = new DatagramPacket(sendBuf ,sendBuf.length , addr , port);
	        int i = 0;
	        sendPacket.setData(sendBuf);
	        while(i < 500){
	        	String Str = "This is :"+i;
	        	sendBuf = Str.getBytes();
	        	sendPacket.setData(sendBuf);
	        	client.send(sendPacket);
	        	i++;
	        }
//	        byte[] recvBuf = new byte[100];
//	        DatagramPacket recvPacket
//	            = new DatagramPacket(recvBuf , recvBuf.length);
//	        
//	        client.receive(recvPacket);
//	        String recvStr = new String(recvPacket.getData() , 0 ,recvPacket.getLength());
//	        System.out.println("收到:" + recvStr);
	        client.close();
	    }
}