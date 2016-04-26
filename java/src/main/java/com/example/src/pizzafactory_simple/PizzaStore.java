package com.example.src.pizzafactory_simple;

public abstract class PizzaStore {
	
	
	public Pizza orderPizza(String type){
		Pizza pizza;
		
		pizza = createPizze(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}

	public abstract Pizza createPizze(String type);
}
