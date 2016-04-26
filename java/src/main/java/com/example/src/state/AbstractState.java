package com.example.src.state;

public abstract class AbstractState implements InterfaceState{
	
	public AbstractState(){
		
	}
	
	public void insertQuarter(){
		System.out.println("You can't insert another quarter!");
	}
	
	public void ejectQuarter(){
		System.out.println("You haven't inserted a quarter!");
	}
	
	public void turnCrank(){
		System.out.println("You turn,but there's no quarter!");
	}
	
	public void dispense(){
		System.out.println("You need to play first!");
	}
}
