/**
 * 
 */
package com.example.src.ornament;

/**
 * @author Arales
 *
 */
public class Soy extends CondimentDecorator{

	Beverage beverage;
	
	public Soy(Beverage beverage) {
		this.beverage = beverage;
		// TODO Auto-generated constructor stub
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return beverage.cost()+0.15;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription()+","+"Soy";
	}

}
