package com.example.src.startegy;

public class ClassRubberDuck extends AbstractDuck{

	public ClassRubberDuck() {
		flyBehavior = new WidgetFlyNothing();
		quackBehavior = new WidgetMuteQuack();
	}

	@Override
	public void disPlay() {
		// TODO Auto-generated method stub
		System.out.println("I'm a rubber duck!!");
		performFly();
		performQuack();
	}
}
