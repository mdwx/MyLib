package com.example.src.ForTest;

import java.util.ArrayList;
import java.util.List;


public class LCS {
	 
	 static int bSearch(int Key, List<Integer> b)  
	 {  
	     int low=-1, high=b.size()-1;  
	     int guess;
	     
	     while (high - low > 1) {
	            guess = ((high - low)>>1)  + low;
	            
	            if(Key > b.get(guess))
	             {
	                low = guess;	            
	            }
	            else
	            { 
	                high = guess;
	            }
	        }
	   
	     return high;  
	 }  
	  
	 public static void main(String[] args) {
	  
		 
		  int p[]=new int[]{1,7,3,5,8,9,7,10,5,9,18,6,56,34,40,41,42,43,44,45,78,11,23,4,6,28,19,
				  29,32,30,15,32,33,19,35,36,37,38,39,100};
		  List<Integer> b = new ArrayList<Integer>();//保存当前长度的最小数
		 	
		  List<ArrayList<Integer>> LCS = new ArrayList<ArrayList<Integer>>();//保存递归状态数
		 
		  
		 	b.add(p[0]);
		 	LCS.add(new ArrayList<Integer>());
		 	LCS.get(0).add(p[0]);
		 			 	
		 	for(int i=0; i<p.length; i++)
		 	{
		 		if(p[i] > b.get(b.size()-1))//p[n]满足条件，最大长度加一，b数组记录长度，LCS数组记录待选数值
		 		{
		 			b.add(p[i]);
		 			LCS.add(new ArrayList<Integer>());	
		 			LCS.get(LCS.size()-1).add(p[i]);		 			
		 		}
		 		else//添加到适合的位置
		 		{
		 			int pos = bSearch(p[i],b);
		 	
		 			b.set(pos, p[i]);	
		 			
		 			if(pos == b.size()-1){//如果位置在最后，则直接取代原来的值
		 				LCS.get(pos).set(0, p[i]);
		 			}
		 			else if(p[i] != LCS.get(pos).get(LCS.get(pos).size()-1)){//否则加入待选数组		 				
		 				LCS.get(pos).add(p[i]);		 				
		 			}
		 		}
		 	}
		 	
		 	for(int i =LCS.size()-1; i>=0; i--){
		 		if(LCS.get(i).size() > 1){//如果待选数组有其他值，选择满足条件的最大值
		 			int k=0;
		 			while(LCS.get(i).get(k) >= LCS.get(i+1).get(0)){
		 				k++;
		 			}
		 			
		 			LCS.get(i).set(0, LCS.get(i).get(k));
		 			
		 			while(LCS.get(i).size()>1){//清空无效值
		 				LCS.get(i).remove(LCS.get(i).size()-1);
		 			}
		 		}
		 	}		 	
		 System.out.println(b.size());	
		 System.out.println(LCS);
	 }
}
