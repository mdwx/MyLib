package com.example.src.startegy;

public class ClassDecoyDuck extends AbstractDuck{
	
	public ClassDecoyDuck() {
		flyBehavior = new WidgetFlyWithWings();
		quackBehavior = new WidgetSqueak();
	}

	@Override
	public void disPlay() {
		// TODO Auto-generated method stub
		System.out.println("I'm a decoy duck!!");
		performFly();
		performQuack();
	}
}
