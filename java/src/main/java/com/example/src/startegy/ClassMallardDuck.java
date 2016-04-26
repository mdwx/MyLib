package com.example.src.startegy;

public class ClassMallardDuck extends AbstractDuck{

	public ClassMallardDuck(){
		flyBehavior = new WidgetFlyWithWings();
		quackBehavior = new WidgetQuack();
	}
	
	@Override
	public void disPlay() {
		// TODO Auto-generated method stub
		System.out.println("I'm mallard!!");
		performFly();
		performQuack();
	}

}
