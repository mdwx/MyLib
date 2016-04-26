package com.example.src.pizzafactory_Abstract;

public class NewYorkIngredineFactory implements PizzaIngredienFactory {

	public Dough createDough() {
		// TODO Auto-generated method stub
		return new DoughNewYork();
	}

	public Sauce createSauce() {
		// TODO Auto-generated method stub
		return new SauceGermany();
	}
}
