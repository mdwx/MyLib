package com.example.src.ornament;

public class EntityDarkRoast extends Beverage {
	
	public EntityDarkRoast(String size) {
		super();
		// TODO Auto-generated constructor stub
		this.description =size+" DarkRoast";
		this.size = size;
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 0.99;
	}
}
