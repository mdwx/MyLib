package com.example.src.ForTest;

import java.lang.reflect.Field;

public class Parse {

	public Parse(int len, int type, int channe_num, int sample_rate,
			int sample_num, int sample_fmt, int data) {
		super();
		this.len = len;
		this.type = type;
		this.channe_num = channe_num;
		this.sample_rate = sample_rate;
		this.sample_num = sample_num;
		this.sample_fmt = sample_fmt;
		this.data = data;
	}
	
	public Parse() {
		// TODO Auto-generated constructor stub
	}

	public void setParse(Parse parser) {
		// TODO Auto-generated constructor stub
		this.len = parser.getLen();
		this.type = parser.getType();;
		this.channe_num = parser.getChanne_num();;
		this.sample_rate = parser.getSample_rate();;
		this.sample_num = parser.getSample_num();;
		this.sample_fmt = parser.getSample_fmt();;
		this.data = parser.getData();;
	}

	private int len;
	private int type;
	private int channe_num;
	private int sample_rate;
	private int sample_num;
	private int sample_fmt;
	private int data;
	
	
	public int getLen() {
		return len;
	}
	public void setLen(int len) {
		this.len = len;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getChanne_num() {
		return channe_num;
	}
	public void setChanne_num(int channe_num) {
		this.channe_num = channe_num;
	}
	public int getSample_rate() {
		return sample_rate;
	}
	public void setSample_rate(int sample_rate) {
		this.sample_rate = sample_rate;
	}
	public int getSample_num() {
		return sample_num;
	}
	public void setSample_num(int sample_num) {
		this.sample_num = sample_num;
	}
	public int getSample_fmt() {
		return sample_fmt;
	}
	public void setSample_fmt(int sample_fmt) {
		this.sample_fmt = sample_fmt;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
	public static int setParse(Parse parser, byte[] buf){
		Field[] fields = parser.getClass().getDeclaredFields();
		
		if(buf.length >= fields.length * 4){
			int i;
			byte[] tem = new byte[4];
			tem[0] =  buf[0];
			for(i =1; i<fields.length*4; i++){
				
				
				tem[i%4] = buf[i];		
				if((i+1)%4 == 0){
					switch((i+1)/4){
						case 1:	
							parser.setLen(littlebyteArrayToInt(tem));
							break;
						case 2:	
							parser.setType(littlebyteArrayToInt(tem));
							break;
						case 3:	
							parser.setChanne_num(littlebyteArrayToInt(tem));
							break;
						case 4:		
							parser.setSample_rate(littlebyteArrayToInt(tem));
							break;
						case 5:		
							parser.setSample_num(littlebyteArrayToInt(tem));
							break;
						case 6:		
							parser.setSample_fmt(littlebyteArrayToInt(tem));
							break;
						case 7:		
							parser.setData(littlebyteArrayToInt(tem));
							break;
					} 
				}
			}
			return fields.length * 4;
				

		}
		return -1;
	}
	//byte 数组与 int 的相互转换  
    public static int bigbyteArrayToInt(byte[] b) {  
        return   b[3] & 0xFF |  
                (b[2] & 0xFF) << 8 |  
                (b[1] & 0xFF) << 16 |  
                (b[0] & 0xFF) << 24;  
    }  
  //byte 数组与 int 的相互转换  
    public static int littlebyteArrayToInt(byte[] b) {  
        return   b[0] & 0xFF |  
                (b[1] & 0xFF) << 8 |  
                (b[2] & 0xFF) << 16 |  
                (b[3] & 0xFF) << 24;  
    }  
  
    public static byte[] intToByteArray(int a) {  
        return new byte[] {  
            (byte) ((a >> 24) & 0xFF),  
            (byte) ((a >> 16) & 0xFF),     
            (byte) ((a >> 8) & 0xFF),     
            (byte) (a & 0xFF)  
        };  
    }
	@Override
	public String toString() {
		return "Parse [len=" + len + ", type=" + type + ", channe_num="
				+ channe_num + ", sample_rate=" + sample_rate + ", sample_num="
				+ sample_num + ", sample_fmt=" + sample_fmt + ", data=" + data
				+ "]";
	}	
	
	public static void main(String[] args) {
		Parse pas = new Parse();
		byte[] buf = new byte[100];
		byte[] tem;
		for(int i=0; i<8; i++)
		{
			
			tem = Parse.intToByteArray(10*i+20);
			for(int j=0; j<4; j++){
				buf[i*4+j] = tem[3-j];
			}
			
		}
		
		Parse.setParse(pas, buf);
		System.out.println(pas);
		
	}
}
