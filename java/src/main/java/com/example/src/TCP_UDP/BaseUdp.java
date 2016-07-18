package com.example.src.TCP_UDP;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Arales on 2016/7/18.
 * E_mail :  xhys01@163.com
 * Description :
 */
public class BaseUDP {

    public static void main(String[] args)throws IOException, InterruptedException{

        DatagramSocket server = new DatagramSocket(5555);
        byte[] recvBuf = new byte[4*1024];;
        DatagramPacket recvPacket
                = new DatagramPacket(recvBuf , recvBuf.length);

        File file=new File("E:\\test.mkv");
        if(!file.exists()){
            System.out.println("error");
            return;
        }
        FileInputStream fis = new FileInputStream(file);
        int readLen;
        server.receive(recvPacket);
        System.out.println(new String(recvPacket.getData() , 0 ,recvPacket.getLength()));
         while((readLen=fis.read(recvBuf)) !=-1 ){
            DatagramPacket sendPacket = new DatagramPacket(recvBuf , readLen , recvPacket.getAddress() , recvPacket.getPort() );
            server.send(sendPacket);
             Thread.sleep(3);
        }
        DatagramPacket sendPacket = new DatagramPacket(recvBuf , 3 , recvPacket.getAddress() , recvPacket.getPort() );
        server.close();
    }

}
