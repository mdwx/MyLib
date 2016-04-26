package com.example.src.ForTest;

public class Unifind {	
	private int father[];
	
	public Unifind(){}	
	public Unifind(int size)
	{
	
		father = new int[size];
		for(int i=0; i<size; i++)
		{
			father[i] = i;
		}
	}			
	
	public void union(int... Array)
	{
		int x,y;
		if(Array.length > 1)
		{
			for(int i=0; i<Array.length-1; i++)
			{
				x = _find(Array[i]);
				y = _find(Array[i+1]);	
				
				if(x > y){
		            father[x] = y;
		        }
		        else {
		            father[y] = x;
		        }
			}
		}
		else if(Array.length == 1)
		{
			father[Array[0]] = Array[0];
		}		
	}
	
	public boolean IsUnit(int... Array)
	{
		if(Array.length < 2)
		{
			return true;
		}
		
		for(int i=0; i<Array.length-1; i++)
		{
			if (_find(Array[i]) != _find(Array[i+1]))
			{
				return false;
			}
		}
		return true;
	}
	
	
	
	private int _find(int x)
	{
		if (father[x] != x)
		{
			father[x] = _find(father[x]);
		}
		return father[x];
	}
	
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
	    	
		 Unifind Unifind = new Unifind(30);
		 
//		 (2,4) {2,4}
//		 (5,7) {2,4} {5,7}
//		 (1,3) {1,3} {2,4} {5,7}
//		 (8,9) {1,3} {2,4} {5,7} {8,9}
//		 (1,2) {1,2,3,4} {5,7} {8,9}
//		 (5,6) {1,2,3,4} {5,6,7} {8,9}
//		 (2,3) {1,2,3,4} {5,6,7} {8,9}
		 Unifind.union();
		 Unifind.union(2, 4);
		 Unifind.union(5, 7, 6);
		 Unifind.union(8, 9);
		 Unifind.union(1, 2, 3);    
		 
		 System.out.println(Unifind.IsUnit(1, 2,4,3));
		 System.out.println(Unifind.IsUnit(1, 2,6,3));
		 Unifind.union(1, 2, 3, 4, 5, 6, 7, 8, 9);    
		 System.out.println(Unifind.IsUnit(1, 2,6,3));
		 Unifind.union(1);
		 System.out.println(Unifind.IsUnit(1, 2,6,3));		
			 
		}

}
