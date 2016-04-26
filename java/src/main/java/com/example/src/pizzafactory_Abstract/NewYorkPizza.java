package com.example.src.pizzafactory_Abstract;

public class NewYorkPizza extends Pizza{
	PizzaIngredienFactory pizzaIngredienFactory;
	
	public NewYorkPizza(PizzaIngredienFactory pizzaIngredienFactory) {
		super();
		// TODO Auto-generated constructor stub
		this.name = "NYPizza";
		this.pizzaIngredienFactory = pizzaIngredienFactory;
	}

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		 dough = pizzaIngredienFactory.createDough();
		 sauce = pizzaIngredienFactory.createSauce();
	}
	
}
