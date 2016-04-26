package com.example.src.state;

public class StateSold extends AbstractState{

	GumballMachine gumballMachine;
	
	public StateSold(GumballMachine gumballMachine){
		 this.gumballMachine = gumballMachine;
	}
	
	public void dispense(){
		gumballMachine.releaseBall();
		if(gumballMachine.getCount() > 0){
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		}
		else{
			System.out.println("Oops! out of gumball!");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}		
	}
}
