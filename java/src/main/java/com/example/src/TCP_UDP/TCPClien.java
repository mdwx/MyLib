package com.example.src.TCP_UDP;

/**
 *TCPClient
 *@author Winty wintys@gmail.com
 *@version 2008-12-15
 */
import java.io.*;
import java.net.*;
class TCPClient{
    public static void main(String[] args)throws IOException{
        Socket client = new Socket("127.0.0.1" , 5050);
        InputStream in = client.getInputStream();
        OutputStream out = client.getOutputStream();
        
        out.write('c');
        char c = (char)in.read();
        System.out.println(" ’µΩ:" + c);
        out.close();
        in.close();
        client.close();
    }
}
