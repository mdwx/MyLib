package com.example.src.Adapter;


public class Adapter extends Source implements interfaceTargetable{//设计模式适配器

	private Source source = null;  
    
    public Adapter(Source source){  
        super();  
        this.source = source;  
    }  
  
  
    @Override  
    public void method1() { 
    	if(source != null)
    	{
    		source.method1();  
    	}
    	else
    	{
    		super.method1();
    	}    	
    } 
    
	public void method2() {
		// TODO Auto-generated method stub		
		 System.out.println("this is the targetable method!");  
	}
	
	
	public static void main(String[] args) {
		  Source source = new Source();  
		  interfaceTargetable target = new Adapter(source);  
	        target.method1();  
	        target.method2();  
	}

}
