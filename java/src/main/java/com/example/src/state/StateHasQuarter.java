package com.example.src.state;

public class StateHasQuarter extends AbstractState{
	GumballMachine gumballMachine;
	
	public StateHasQuarter(GumballMachine gumballMachine){
		 this.gumballMachine = gumballMachine;
	}
	
	public void insertQuarter(){
		System.out.println("You can't insert another quarter!");
	}
	public void ejectQuarter(){
		System.out.println("Quarter returned!");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}
	
	public void turnCrank(){
		gumballMachine.setState(gumballMachine.getSoldState());
	}

}
