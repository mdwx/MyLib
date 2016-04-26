package com.example.src.factory;

public class Abstract_ProviderB implements Abstract_Provider{

	public ItemB produce() {
		// TODO Auto-generated method stub
		
	//  return Factory.createObj(ItemB.Path);  
		return new ItemB();
	}

}
