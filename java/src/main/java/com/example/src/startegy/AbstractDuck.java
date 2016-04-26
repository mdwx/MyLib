package com.example.src.startegy;

public abstract class AbstractDuck {

	InterfaceFlyBehavior flyBehavior;
	InterfaceQuackBehavior quackBehavior;
	
	public AbstractDuck(){}
	
	public abstract void disPlay();
	
	public void performFly(){
		flyBehavior.Fly();
	}
	
	public void performQuack(){
		quackBehavior.Quack();
	}

	public void swin(){
		System.out.println("All ducks float,even decoys!");
	}

	public InterfaceFlyBehavior getFlyBehavior() {
		return flyBehavior;
	}

	public void setFlyBehavior(InterfaceFlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public InterfaceQuackBehavior getQuackBehavior() {
		return quackBehavior;
	}

	public void setQuackBehavior(InterfaceQuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
}

