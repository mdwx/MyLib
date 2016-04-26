package com.example.src.state;

public class GumballMachine {

	InterfaceState noQuarterState;
	InterfaceState HasQuarterState;
	InterfaceState StateSold;
	InterfaceState StateSoldOut;
	
	InterfaceState state= StateSoldOut;
	int count = 0;
	
	public GumballMachine() {super();}
	public GumballMachine(int count) {
		super();
		noQuarterState = new StateNoQuarter(this);
		HasQuarterState = new StateHasQuarter(this);
		StateSold = new StateSold(this);
		StateSoldOut = new StateSoldOut();
		state = noQuarterState;
		this.count = count;
	}	

	public void setState(InterfaceState state) {
		// TODO Auto-generated method stub
		this.state = state;
	}
	
	public void insertQuarter(){
		state.insertQuarter();
	}
	
	public void ejectQuarter(){
		state.ejectQuarter();
	}
	
	public void turnCrank(){
		state.turnCrank();
		state.dispense();
	}	
	

	public InterfaceState getNoQuarterState() {
		// TODO Auto-generated method stub
		return noQuarterState;
	}
	public InterfaceState getHasQuarterState() {
		// TODO Auto-generated method stub
		return HasQuarterState;
	}
	public InterfaceState getSoldState() {
		// TODO Auto-generated method stub
		return StateSold;
	}
	public InterfaceState getSoldOutState() {
		// TODO Auto-generated method stub
		return StateSoldOut;
	}

	public void releaseBall() {
		// TODO Auto-generated method stub
		if(count>0){
			System.out.println("a gumball comes rolling  out the sold..");
			count--;
		}
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return count;
	}

}
