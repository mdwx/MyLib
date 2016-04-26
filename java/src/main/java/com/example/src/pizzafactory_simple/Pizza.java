package com.example.src.pizzafactory_simple;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {

	String name;
	String dough;
	String sauce;
	List<Object> toppings = new ArrayList<Object>();
	
	public void prepare() {
		// TODO Auto-generated method stub
		System.out.println("Preparing "+name);
		System.out.println("Tossing dough");
		System.out.println("Adding sauce");
		System.out.println("Adding Toppings");
		
	}

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
				+ ", toppings=" + toppings + "]";
	}

}
