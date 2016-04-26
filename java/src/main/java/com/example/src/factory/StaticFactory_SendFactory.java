package com.example.src.factory;

public class StaticFactory_SendFactory {

	public static ItemA produceA(){  
      //  return Factory.createObj(ItemA.Path);  
		return new ItemA();
    }  
	
	public static ItemB produceB(){  
	      //  return Factory.createObj(ItemB.Path);  
			return new ItemB();
	    }  	
	
	
	public static void main(String[] args)
	{
		ItemA A = StaticFactory_SendFactory.produceA();
		ItemB B = StaticFactory_SendFactory.produceB();
		
		System.out.println(A);
		System.out.println(B);
	}
}
