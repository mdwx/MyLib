package com.example.src.RingBuffer;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UDPWavefRecv server = new UDPWavefRecv(9527, 1000); 
		RingBuffer Buffer = new RingBuffer();
		int len = 0;
		byte[] mwaveform = new byte[10];
		int i = 0;
		while(i < 1000){
			if((len = server.receive()) > 0 ){
	
				Buffer.insert(server.getrecvPacket().getData(), len);
				
				if(Buffer.read(mwaveform, mwaveform.length) > 0){
					Buffer.pop( mwaveform.length);
					String recvStr = new String(mwaveform, 0 ,mwaveform.length);
					System.out.println(recvStr);
				}
			}
			i++;
		}
	}
}
