package com.example.src.fonsview;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Arales on 2016/8/4.
 * E_mail :  xhys01@163.com
 * Description :
 */
public class Decode {
    private  RingBuffer BUFF = null;
    private Calendar calendar;
    private SimpleDateFormat DateFormat;
    private boolean receive_flag = false;

//    static {
//        System.loadLibrary("p2pvod");
//    }
//    public native int get_peer_stream_req_str(char[] contentinfo, char[] sendbuff, char[] prsip);

    public int start(Socket sockclient, final byte[] receiveBuf, final Peer peer){
        DateFormat = new SimpleDateFormat("EEE d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        DateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        calendar = Calendar.getInstance();
       
        try {
            String str = new String(receiveBuf);

            if(str.indexOf("GET ") != -1) {
            	final String sendStr = decodePlayStr(receiveBuf, peer);
            	if(null != sendStr){
            		 if (null == BUFF) {
            	            BUFF = new RingBuffer();
            	        }
            		answerPlayer(sockclient.getOutputStream());
		            new Thread(new Runnable() {
		                @Override
		                public void run() {
		                    try {
		                        ReceiveMedia(receiveBuf,sendStr,peer);
		                    } catch (SocketException e) {
		                        e.printStackTrace();
		                    }
		                }
		            }).start();		           
		           play(sockclient);
            }
        }

            if(str.indexOf("LOCAL") != -1) {            	
                SendMedia(receiveBuf); 
            }
            if(str.indexOf("STREAM_SERVER") != -1) {
                InitPeerInfo(receiveBuf,peer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    private void answerPlayer(OutputStream out) {
	// TODO Auto-generated method stub
    	String sendStr =  "HTTP/1.1 200 OK\r\n"+
                DateFormat.format(calendar.getTime()).toString()+"\r\n" +
                "Server: Apache\r\n"+
                "Accept-Ranges: none\r\n"+
                "Keep-Alive: timeout=15, max=100\r\n\r\n";
        // System.out.println(sendStr);
        byte[] sendBuf;
        sendBuf = sendStr.getBytes();       
        try {          
            out.write(sendBuf);
        } catch (IOException e) {
            e.printStackTrace();
        }	
}

	private void InitPeerInfo(byte[] receiveBuf, Peer peer) {
        String regEx = ".*?(?=,)";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher;
        String str = new String(receiveBuf);
        matcher = pattern.matcher(str);

        int i =0;
        while(matcher.find())
        {
            if(2 == i){
                peer.setRunFlag(Integer.valueOf(matcher.group(0)));
            }
            if(4 == i){
                peer.setId(new String(matcher.group(0)));
            }
            if(6 == i){
                peer.setIp(new String(matcher.group(0)));
            }
            if(8 == i){
                peer.setContentPath(new String(matcher.group(0)));
            }
            if(10 == i){
                peer.setPrsip(new String(matcher.group(0)));
                break;
            }
            System.out.println(matcher.group(0) +" "+ i++);
        }
    }

    private void play(Socket sockclient) throws IOException{       
      
        OutputStream out = null;
        try {
            out = sockclient.getOutputStream();            
            int BufLen = 7*188;
            byte[] buff = new byte[BufLen];
            int readLen;
            if(!receive_flag){
            	Thread.sleep(500);
            }
            System.out.println("read Start"+ String.valueOf(BUFF.size()));
            do{
            	Thread.sleep(200);
                while ((readLen = BUFF.read(buff)) != -1) {
                    if (readLen == BufLen) {
                        out.write(buff);
                    }
                    BUFF.pop(readLen);
                }                
            }while(receive_flag);
            
            if ((readLen = BUFF.read(buff)) != -1) {
                 System.out.println("read last BUFF" + String.valueOf(BUFF.size()));             	 
                 out.write(buff,0,readLen);
                 BUFF.pop(readLen);
            }       
	        System.out.println("read over"+ String.valueOf(BUFF.size()));  

        } catch (IOException e) {
        	  System.out.println("Socket closed.. ");  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
        	sockclient.close();
        }
    }

    private void ReceiveMedia(byte[] receiveBuf, String sendStr,Peer peer) throws SocketException {
        ReceiveSocket serverSocket = null;

        try {
            serverSocket = new ReceiveSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        
        System.out.println(sendStr);
        byte[] sendBuf;
        sendBuf = sendStr.getBytes();

        byte[] recvBuf = new byte[4 * 1024];
        DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);

        serverSocket.setSoTimeout(10*1000);
        int i = 0;
        while (i<3)  {
        	 System.out.println("Socket send Message Start...");
             i++;
            try {
                serverSocket.sendPacket(InetAddress.getByName(peer.getPrsip()), 8003, UdpSocket.MESSAGE_ID, 0, sendBuf.length, "172.16.0.132", 8001, sendBuf);
                serverSocket.receive(recvPacket);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Socket receive Timeout!!!;");
                continue;
            }
            break;
        }
        serverSocket.setPacketCallBack(new PacketCallBack(BUFF) {
            @Override
            public void CallBack(Object param, Object packetData) {
                ((RingBuffer) param).insert(((PackFormat) packetData).getData(), ((PackFormat) packetData).getData().length);
            }
        });

        serverSocket.setSoTimeout(500);
        receive_flag = true;
        serverSocket.start();
        serverSocket.Close();
        receive_flag = false;
    }

    private String decodePlayStr(byte[] receiveBuf, Peer peer) {
        String str = new String(receiveBuf);
        String contentID = null;
        String contentFle =null;

        Pattern pattern = Pattern.compile("(?<=GET ).*?(?= HTTP)");
        Matcher matcher;
        matcher = pattern.matcher(str);

        if(matcher.find())
        {
            contentFle = new String(matcher.group(0));
            System.out.println(matcher.group(0));
        }
        matcher = Pattern.compile("(?<=/).*?(?=/)").matcher(contentFle);

        if(matcher.find()){
            contentID = new String( matcher.group(0));
            System.out.println(matcher.group(0));
        }
        else{
        	return null;
        }

        return "<?xml version=\"1.0\" encoding=\" UTF-8\"?>\n" +
                "<message>\n" +
                "<header>\n" +
                "\t\t<sequence>124</sequence>\n" +
                "        <timeStamp>2015-12-05T17:57:40</timeStamp>\n" +
                "\t\t<commandType>PeerStreamReq</commandType>\n" +
                "        <peerID>"+peer.getId()+"</peerID>\n" +
                "</header>\n" +
                "<body>\n" +
                "\t\n" +
                "<contentID>"+contentID+"</contentID>\n" +
                "<contentAddr>"+peer.getContentPath()+contentFle+"</contentAddr>\n" +
                "</body>\n" +
                "</message>\r\n\r\n";
    }


    private void SendMedia(byte[] receiveBuf)  throws Exception{

        SendSocket clientSocket = new SendSocket();
        int dataSequence = 0;
        String PrsAddr = "172.16.0.132";
        String sentoaddr = "172.16.12.22";
        String contenID = "2-6";
        String contenAddr = "E:\\2_6.ts";
        int sentoprot = 8001;

        String regEx = ".*?(?=,)";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher;
        String str = new String(receiveBuf);

        matcher = pattern.matcher(str);
        int i =0;
        while(matcher.find())
        {
            if(2 == i){
                sentoprot = Integer.valueOf(matcher.group(0));
            }
            if(4 == i){
                sentoaddr = new String(matcher.group(0));
            } 
            if(6 == i){
                contenID =  new String(matcher.group(0));
            }
            if(8 == i){
                contenAddr = new String(matcher.group(0));
            }
            if(10 == i){
                PrsAddr = new String(matcher.group(0));
                break;
            }
            System.out.println(matcher.group(0) +" "+ i++);
        }
        File file=new File(contenAddr);
        if(!file.exists()){
            System.out.println("error");
            return;
        }
        System.out.println(" File file=new File(contenAddr);");
        int BufLen = 7*188;
        PackFormat recvData = new PackFormat(new byte[BufLen] ,BufLen, dataSequence++, UdpSocket.PKT_ID,sentoaddr, sentoprot,UdpSocket.START_ID);
        clientSocket.setDestnation(PrsAddr,8001);
        clientSocket.sendStart();

        int readLen;
        FileInputStream fis = new FileInputStream(file);        
        while((readLen=fis.read(recvData.getData())) != -1 ){
            if(readLen == BufLen) {
                clientSocket.enqueue(recvData);
            }else{
                PackFormat data = new PackFormat(new byte[readLen] ,readLen, dataSequence++, UdpSocket.PKT_ID,sentoaddr, sentoprot,UdpSocket.START_ID);
                System.arraycopy(recvData.getData(), 0, data.getData(), 0, readLen);
                clientSocket.enqueue(data);
                continue;
            }
            recvData = new PackFormat(new byte[BufLen] ,BufLen, dataSequence++,UdpSocket.PKT_ID,sentoaddr, sentoprot,UdpSocket.START_ID);
        }
        clientSocket.enqueue(new PackFormat(new byte[1], 1, dataSequence++,UdpSocket.UDP_END_ID,sentoaddr, sentoprot,UdpSocket.START_ID));
        clientSocket.Close();
    }
}
