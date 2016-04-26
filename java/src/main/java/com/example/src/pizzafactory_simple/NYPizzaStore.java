package com.example.src.pizzafactory_simple;

public class NYPizzaStore extends PizzaStore{

	@Override
	public Pizza createPizze(String type) {
		// TODO Auto-generated method stub
		return new NYPizza();
	}

}
