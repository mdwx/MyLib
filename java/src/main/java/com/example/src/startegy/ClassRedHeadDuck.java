package com.example.src.startegy;

public class ClassRedHeadDuck extends AbstractDuck{
	
	public ClassRedHeadDuck() {
		flyBehavior = new WidgetFlyWithWings();
		quackBehavior = new WidgetQuack();
	}

	@Override
	public void disPlay() {
		// TODO Auto-generated method stub
		System.out.println("I'm red head duck!!");
		performFly();
		performQuack();
	}
}
