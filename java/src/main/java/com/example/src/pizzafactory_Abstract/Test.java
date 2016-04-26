package com.example.src.pizzafactory_Abstract;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PizzaStore NYStore = new NewYorkPizzaStore();
		
		Pizza pizza = NYStore.orderPizza("");
		System.out.println(pizza.toString());
		
		PizzaStore ChicageStore = new ChicagoStyleStore();
		pizza = ChicageStore.orderPizza("");
		System.out.println(pizza.toString());
	}

}
