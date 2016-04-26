package com.example.src.ornament;

public abstract class Beverage {

	String description ="Unknow Beverage";
	String size = "Unknow size";
	
	public String getDescription() {				  
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	public abstract double cost();

	

	
}
