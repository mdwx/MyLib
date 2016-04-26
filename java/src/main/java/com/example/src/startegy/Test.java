package com.example.src.startegy;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractDuck mallar = new ClassMallardDuck();
		AbstractDuck redhead = new ClassRedHeadDuck();
		AbstractDuck decoy = new ClassDecoyDuck();
		AbstractDuck rubber = new ClassRubberDuck();
		
		mallar.disPlay();
		redhead.disPlay();
		decoy.disPlay();
		rubber.disPlay();
		
		decoy.setFlyBehavior(new WidgetFlyNothing());
		decoy.disPlay();
	}

}
