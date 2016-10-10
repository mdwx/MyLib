package com.example.src.fonsview;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Arales on 2016/7/27.
 * E_mail :  xhys01@163.com
 * Description :
 */
public class LocalHttpServer extends Thread{

    private boolean peer_runFlag;
    private  ServerSocket listen;
    private  int SocketPort = 8973;
    private  Socket sockclient;
    private  byte[] receiveBuf;
    private  int  receiveBufLen = 2*1024;
    protected static final int SOCK_RECV_BUF_SIZE = 1024*1024;
    protected static final int SOCK_SEND_BUF_SIZE = 1024*1024;
    private Peer peer;

    public LocalHttpServer() throws IOException {
        super("LocalHttpServer");
        LocalHttpServerInit();
    }

    public LocalHttpServer(int port) throws IOException {
        super("LocalHttpServer");
        SocketPort = port;
        LocalHttpServerInit();
    }
    private void LocalHttpServerInit() throws IOException {
        listen = new ServerSocket(SocketPort);
        listen.setReuseAddress(true);
        peer_runFlag = true;
        peer = new Peer();
        //setDaemon(true);
    }

    public int socketRead(InputStream in,byte[] receiveBuf, String s){
        int receiveLen = 0;
        while (true) {
            int  TemLen = 0;
            try {
                TemLen = in.read(receiveBuf, receiveLen, receiveBufLen - receiveLen);
            } catch (IOException e) {
                e.printStackTrace();
            }
            receiveLen += TemLen;
            String str = new String(receiveBuf);
            if (str.contains(s)) {
                break;
            }            
            if(receiveLen >= receiveBufLen){
            	receiveLen = 0;
            }
        }
        return receiveLen;
    }
    public void run() {
        System.out.println("LocalHttpServer is runing");
        while(peer_runFlag) {
            try {
            	listen.setSoTimeout(1000);
                sockclient = listen.accept();

                sockclient.setKeepAlive(true);
                sockclient.setReceiveBufferSize(SOCK_RECV_BUF_SIZE);
                sockclient.setSendBufferSize(SOCK_SEND_BUF_SIZE);

                InputStream in = sockclient.getInputStream();
                receiveBuf  = new byte[receiveBufLen];
                int strlen = socketRead(in, receiveBuf, "\r\n\r\n");
                System.out.println(new String(receiveBuf,0,strlen));
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        new Decode().start(sockclient,receiveBuf,peer);
                    }
                }).start();

            } catch (IOException e) {
              
            }
        }
        try {
			listen.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void Stop(){
        peer_runFlag = false;
    }
    public boolean IsRuning() {
        return peer_runFlag; 
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        LocalHttpServer localHttpServer = new LocalHttpServer(8973);
        localHttpServer.start();
        while(true){
            Thread.sleep(1000);
        }
    }
}
