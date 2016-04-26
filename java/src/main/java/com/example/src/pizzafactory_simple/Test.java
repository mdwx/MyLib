package com.example.src.pizzafactory_simple;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PizzaStore NYStore = new NYPizzaStore();
		
		Pizza pizza = NYStore.orderPizza("");
		System.out.println(pizza.toString());
		
		PizzaStore ChicageStore = new ChicageStyleStore();
		pizza = ChicageStore.orderPizza("");
		System.out.println(pizza.toString());
	}

}
