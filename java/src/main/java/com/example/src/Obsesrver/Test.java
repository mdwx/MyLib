package com.example.src.Obsesrver;

import java.util.ArrayList;
import java.util.Observable;

public class Test {

	public static void main(String[] args) {
	SubjectWeatherData weatherData = new SubjectWeatherData();
	SubjectWeatherData weatherData2 = new SubjectWeatherData();
	SubjectWeatherData weatherData3 = new SubjectWeatherData();
	ClientCurrentConditionsDisplay CurrentConditions =new ClientCurrentConditionsDisplay();
	//ClientForecastDisplay Forecas = new ClientForecastDisplay();
	//ClientStatisticsDisplay Statistics = new ClientStatisticsDisplay();
	ArrayList<Observable> observableList;	
	observableList = new ArrayList<Observable>();
	observableList.add(weatherData);
	observableList.add(weatherData2);
	observableList.add(weatherData3);
	
	CurrentConditions.setSubscribeList(observableList);

	
//	Forecas.Subscribe
//	Statistics.Subscribe
	CurrentConditions.addObserver(CurrentConditions);
	weatherData.setMeasurements(1, 65, 30.4f);
	weatherData.setMeasurements(2, 70, 29.2f);
	weatherData.setMeasurements(3, 90, 29.2f);	
	weatherData2.setMeasurements(4, 90, 29.2f);
	weatherData3.setMeasurements(5, 90, 29.2f);
	weatherData2.setMeasurements(6, 90, 29.2f);
	weatherData.setMeasurements(7, 90, 29.2f);	
	CurrentConditions.setMeasurements();
	}
	
}
