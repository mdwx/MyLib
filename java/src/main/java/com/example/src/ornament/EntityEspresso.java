package com.example.src.ornament;

public class EntityEspresso extends Beverage{

	public EntityEspresso(String size) {
		super();
		// TODO Auto-generated constructor stub
		description = size+" Espresso";
		this.size = size;
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 1.99;
	}

}
