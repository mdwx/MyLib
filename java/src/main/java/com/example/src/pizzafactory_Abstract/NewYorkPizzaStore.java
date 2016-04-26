package com.example.src.pizzafactory_Abstract;

public class NewYorkPizzaStore extends PizzaStore{
		
	@Override
	public Pizza createPizze(String type) {
		// TODO Auto-generated method stub
		PizzaIngredienFactory pizzaIngredienFactory;
		pizzaIngredienFactory = new NewYorkIngredineFactory();
		
		return new NewYorkPizza(pizzaIngredienFactory);
	}

}
