package com.example.src.state;

public class StateSoldOut extends AbstractState{

	public void insertQuarter(){
		System.out.println("You can't insert a quarter!");
	}	
	
	public void turnCrank(){
		System.out.println("The gumball is empty!!!");
	}
	
	public void dispense(){
		
	}
}
