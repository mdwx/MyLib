package com.example.src.ForTest;


import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * @author Vince  E-mail: xhys01@163.com
 * @version 创建时间：2015-6-9 上午9:27:43 
 * 类说明 
 */
public class PatternMatcher {

	public long a;
	public int b;
	protected float f;
	protected double g;
	
	public PatternMatcher() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {            
			 	PatternMatcher c = new PatternMatcher();
			 	
		        String regEx = "[A-z]*$";
		        Pattern p = Pattern.compile(regEx);  
		        Matcher m;
		        // returns the array of Field objects
		        Field[] fields = c.getClass().getDeclaredFields();
		        for(int i = 0; i < fields.length; i++) {
		        	  m = p.matcher(fields[i].toString());  
		        	  
		        	  while(m.find())
		        	  {
		        		  System.out.println(m.group(0));
		        	  }
		        
		          
		        }
		     }
		     catch(Exception e) {
		        System.out.println(e.toString());
		     }
		  
	}

}
