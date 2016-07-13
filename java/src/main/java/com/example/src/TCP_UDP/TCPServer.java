package com.example.src.TCP_UDP;

/**
 *TCPServer
 *@author Winty wintys@gmail.com
 *@version 2008-12-15
 */
import java.io.*;
import java.net.*;
public class TCPServer{
    public static void main(String[] args)throws IOException{
        ServerSocket listen = new ServerSocket(5050);
        
        Socket server  = listen.accept();
        InputStream in = server.getInputStream();
        OutputStream out = server.getOutputStream();
        char c = (char)in.read();
        System.out.println("收到:" + c);
        out.write('s');
        
        out.close();
        in.close();
        server.close();
        listen.close();
    }
}
