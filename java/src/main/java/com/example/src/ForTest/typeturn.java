package com.example.src.ForTest;

import java.nio.ByteBuffer;

public class typeturn {
	
	private static ByteBuffer buffer = ByteBuffer.allocate(8);  

	
    //byte ������ int ���໥ת��  
    public static int byteArrayToInt(byte[] b) {  
        return   b[3] & 0xFF |  
                (b[2] & 0xFF) << 8 |  
                (b[1] & 0xFF) << 16 |  
                (b[0] & 0xFF) << 24;  
    }  
  
    public static byte[] intToByteArray(int a) {  
        return new byte[] {  
            (byte) ((a >> 24) & 0xFF),  
            (byte) ((a >> 16) & 0xFF),     
            (byte) ((a >> 8) & 0xFF),     
            (byte) (a & 0xFF)  
        };  
    }  
  
    //byte ������ long ���໥ת��  
    public static byte[] longToBytes(long x) {  
        buffer.putLong(0, x);  
        return buffer.array();  
    }  
  
    public static long bytesToLong(byte[] bytes) {  
        buffer.put(bytes, 0, bytes.length);  
        buffer.flip();//need flip   
        return buffer.getLong();  
    }  

public static void main(String[] args) {  
      
     
    //���� int ת byte ����  
    int int2 = 141112127;  
    byte[] bytesInt = intToByteArray(int2);  
   
    //���� byte ����ת int  
    int int3 = byteArrayToInt(bytesInt);  
    System.out.println("int3=" + int3);
      
      
    //���� long ת byte ����  
    long long1 = 2222333;  
    byte[] bytesLong = longToBytes(long1);  
  
    //���� byte ���� ת long  
    long long2 = bytesToLong(bytesLong);  
    System.out.println("long2=" + long2);
}  
  
}
