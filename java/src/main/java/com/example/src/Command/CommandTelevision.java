package com.example.src.Command;

public class CommandTelevision implements Command{
	Television tllevision;
	boolean tllevisionState = false;
	
	public CommandTelevision(Television tllevision){
		this.tllevision = tllevision;
	}

	public void excute() {
		// TODO Auto-generated method stub
		if(tllevisionState){
			tllevision.off();
		}
		else{
			tllevision.on();
		}
		tllevisionState = !tllevisionState;
	}
}
