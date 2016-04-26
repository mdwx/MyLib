package com.example.src.ornament;

public class EntityHouseBlend extends Beverage{

	public EntityHouseBlend(String size) {
		super();
		// TODO Auto-generated constructor stub
		description = size+" HouseBlend";
		this.size = size;
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 0.89;
	}

}
