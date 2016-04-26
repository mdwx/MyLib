package com.example.src.Obsesrver;

import java.util.Observable;

public class SubjectWeatherData extends Observable implements InterfaceWeatherData{
	private float temperature;
	private float humidity;
	private float pressure;
	
	public SubjectWeatherData() { }
	public void measurementsChanged() {
		setChanged();
		notifyObservers();
	}
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
	public float getTemperature() {
		return temperature;
	}
	public float getHumidity() {
		return humidity;
	}
	public float getPressure() {
		return pressure;
	}
	@Override
	public String toString() {
		return "WeatherData [temperature=" + temperature + ", humidity="
				+ humidity + ", pressure=" + pressure + "]";
	}	
}