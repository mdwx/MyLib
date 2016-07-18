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
        byte[] recvBuf = new byte[4*1024];
        DatagramPacket recvPacket = new DatagramPacket(recvBuf , recvBuf.length);

        server.receive(recvPacket);
        System.out.println(new String(recvPacket.getData() , 0 ,recvPacket.getLength()));
        DatagramPacket sendPacket1  = new DatagramPacket(recvBuf , recvBuf.length , recvPacket.getAddress() , recvPacket.getPort() );

        DatagramSocket  server2 = new DatagramSocket();
        DatagramPacket sendPacket2 = new DatagramPacket(recvBuf ,recvBuf.length , InetAddress.getByName("127.0.0.1") , 5555);
        server2.send(sendPacket2);
        server2.setSoTimeout(15000);
            try {
                while (true) {

                    server2.receive(recvPacket);
                    sendPacket1.setLength(recvPacket.getLength());
                    server.send(sendPacket1);
                }
            }catch(IOException e){
                server2.close();
                server.close();
            }

    }
}
