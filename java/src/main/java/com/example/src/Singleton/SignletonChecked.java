package com.example.src.Singleton;

public class SignletonChecked {
	private volatile static SignletonChecked Signleton;
	
	private SignletonChecked(){}
	
	public static SignletonChecked getInstance(){
		
		if(Signleton == null){
			synchronized (SignletonChecked.class) {
				if(Signleton == null){
					Signleton = new SignletonChecked();
				}				
			}			
		}		
		return Signleton;		
	}
}
