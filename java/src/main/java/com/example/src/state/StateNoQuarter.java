package com.example.src.state;

public class StateNoQuarter extends AbstractState{

	GumballMachine gumballMachine;
	
	public StateNoQuarter(GumballMachine gumballMachine){
		 this.gumballMachine = gumballMachine;
	}
	
	public void insertQuarter(){
		System.out.println("You  inserted a quarter!");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}
	
}