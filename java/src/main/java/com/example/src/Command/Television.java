package com.example.src.Command;

public class Television {
	boolean State = false;
	
	public Television(){}
	
	public boolean on(){
		if(State == false){
			State = true;
			System.out.println(" The Television  switched on  was Successful!!");
			return true;
		}
		else{
			System.out.println("The Television  switched on  Error!,The Television  was switched on !!");
			return false;
		}
	}
	
	public boolean off(){
		if(State == true){
			State = false;
			System.out.println("The Television  switched off  was Successful!!");
			return true;
		}
		else{
			System.out.println("The Television  switched off Error!,The Television  was switched off !!");
			return false;
		}
	}
}
