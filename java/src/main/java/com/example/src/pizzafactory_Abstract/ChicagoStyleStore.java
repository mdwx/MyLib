package com.example.src.pizzafactory_Abstract;

public class ChicagoStyleStore extends PizzaStore{

	@Override
	public Pizza createPizze(String type) {
		PizzaIngredienFactory pizzaIngredienFactory;
		pizzaIngredienFactory = new ChicagoIngredineFactory();
		// TODO Auto-generated method stub
		return new ChicagoPizza(pizzaIngredienFactory);
	}

}
