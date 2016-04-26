package com.example.src.pizzafactory_Abstract;

public class ChicagoPizza extends Pizza{
	PizzaIngredienFactory pizzaIngredienFactory;
	
	public ChicagoPizza(PizzaIngredienFactory pizzaIngredienFactory) {
		super();
		// TODO Auto-generated constructor stub
		this.name = "Chicage Pizza";
		this.pizzaIngredienFactory = pizzaIngredienFactory;
	}

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		 dough = pizzaIngredienFactory.createDough();
		 sauce = pizzaIngredienFactory.createSauce();
	}

}
