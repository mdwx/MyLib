package com.example.src.ornament;

public class Whip extends CondimentDecorator {
	Beverage beverage;
	
	public Whip(Beverage beverage) {
		super();
		this.beverage = beverage;
		// TODO Auto-generated constructor stub
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return beverage.cost()+0.1;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription()+","+"Whip";
	}

}
