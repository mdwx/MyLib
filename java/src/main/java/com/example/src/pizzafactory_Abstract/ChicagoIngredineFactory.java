package com.example.src.pizzafactory_Abstract;

public class ChicagoIngredineFactory implements PizzaIngredienFactory {

	public Dough createDough() {
		// TODO Auto-generated method stub
		return new DoughChicago();
	}

	public Sauce createSauce() {
		// TODO Auto-generated method stub
		return new SauceFrench();
	}

}
