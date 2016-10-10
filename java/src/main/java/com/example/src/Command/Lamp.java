package com.example.src.Command;

public class Lamp {
	boolean ligt = false;
	
	public Lamp(){}
	
	public boolean on(){
		if(ligt == false){
			ligt = true;
			System.out.println("Light on Successful!!");
			return true;
		}
		else{
			System.out.println("Light Off Error,The Lamp was switched on!!");
			return false;
		}
	}

	public boolean off(){
		if(ligt == true){
			ligt = false;
			System.out.println("Light Off Successful!!");
			return true;
		}
		else{
			System.out.println("Light Off Error,The Lamp was switched off!!");
			return false;
		}
	}
}
