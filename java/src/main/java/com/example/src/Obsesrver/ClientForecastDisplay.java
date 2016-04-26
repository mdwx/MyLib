package com.example.src.Obsesrver;

import java.util.Observable;

public class ClientForecastDisplay extends AbstractClient implements InterfaceDisplayElement{
	Observable observable;
	
	public ClientForecastDisplay() {super();}
	public ClientForecastDisplay(Observable observable) {
		super(observable);		
	}	

	public void update(Observable obs, Object arg) {
		if (obs instanceof InterfaceWeatherData) {
			InterfaceWeatherData Element = (InterfaceWeatherData)obs;		
			display(""+Element.getPressure());
		}
	}	
	public void display(String str) {
		// TODO Auto-generated method stub
		System.out.println(str);
	}
	
		
}