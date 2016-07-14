package com.example.src.TCP_UDP;

/**
 *UDPServer
 *@author Winty wintys@gmail.com
 *@version 2008-12-15
 */
import java.io.*;
import java.net.*;
public class UDPServer{
    public static void main(String[] args)throws IOException, InterruptedException{
        DatagramSocket  server = new DatagramSocket(8888);
        byte[] recvBuf = new byte[100];
        DatagramPacket recvPacket 
        = new DatagramPacket(recvBuf , recvBuf.length);
        int i =0;
        while(i<1000){
        server.receive(recvPacket);
        System.out.println(new String(recvPacket.getData() , 0 ,recvPacket.getLength()));

        String sendStr = "Server"+i;
        byte[] sendBuf;
        sendBuf = sendStr.getBytes();
        DatagramPacket sendPacket
                = new DatagramPacket(sendBuf , sendBuf.length , recvPacket.getAddress() , recvPacket.getPort() );

    

    //   String recvStr = new String(recvPacket.getData() , 0 , recvPacket.getLength());

        	
        	server.send(sendPacket);
        	i++;
        	
        }
        
        server.close();
    }
}
