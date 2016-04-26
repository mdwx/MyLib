package com.example.src.Obsesrver;

import java.util.Observable;

public class ClientCurrentConditionsDisplay extends AbstractClient implements InterfaceDisplayElement{
		
	public ClientCurrentConditionsDisplay() { super();}
	public ClientCurrentConditionsDisplay(Observable observable) {
		super(observable);
	}
	public void measurementsChanged() {
		setChanged();
		notifyObservers(23);
	}
	public void setMeasurements() {		
		measurementsChanged();
	}
	public void update(Observable obs, Object arg) {
		if (obs instanceof InterfaceWeatherData) {
			InterfaceWeatherData Element = (InterfaceWeatherData)obs;		
			display(Element.toString());
		}
		else{
			System.out.println("Now I'm servers!"+arg);
		}
	}	
	public void display(String str) {
		// TODO Auto-generated method stub
		System.out.println(str);
	}
	
		
}