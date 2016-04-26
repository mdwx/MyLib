package com.example.src.factory;

public class Abstract_ProviderA implements Abstract_Provider{

	public ItemA produce() {
		// TODO Auto-generated method stub
		
		//  return Factory.createObj(ItemA.Path);  
				return new ItemA();
	}

}
