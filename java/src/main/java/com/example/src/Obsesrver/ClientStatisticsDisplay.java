package com.example.src.Obsesrver;

import java.util.Observable;

public class ClientStatisticsDisplay extends AbstractClient implements InterfaceDisplayElement{
	Observable observable;	
	
	public ClientStatisticsDisplay() {super();}
	public ClientStatisticsDisplay(Observable observable) {
		super(observable);		
	}	

	public void update(Observable obs, Object arg) {
		if (obs instanceof InterfaceWeatherData) {
			InterfaceWeatherData Element = (InterfaceWeatherData)obs;		
			display(""+Element.getHumidity());
		}
	}	
	public void display(String str) {
		// TODO Auto-generated method stub
		System.out.println(str);
	}		
}