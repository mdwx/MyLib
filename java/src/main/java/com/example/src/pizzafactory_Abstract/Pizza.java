package com.example.src.pizzafactory_Abstract;

public abstract class Pizza {

	String name;
	Dough dough;
	Sauce sauce;
		
	abstract public void prepare();

	public void bake() {
		// TODO Auto-generated method stub
		System.out.println("bake over!");
	}

	public void cut() {
		// TODO Auto-generated method stub
		System.out.println("cut over!");
	}

	public void box() {
		// TODO Auto-generated method stub
		System.out.println("box over!");
	}

	@Override
	public String toString() {
		return "Pizza [name=" + name + ", dough=" + dough + ", sauce=" + sauce
				+ "]";
	}

	

}
