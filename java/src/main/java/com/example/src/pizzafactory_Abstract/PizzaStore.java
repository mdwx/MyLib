package com.example.src.pizzafactory_Abstract;

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
