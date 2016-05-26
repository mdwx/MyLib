package com.example.src.ForTest;

import java.util.ArrayList;
import java.util.List;


public class LCS {//That's "Longest Common Subsequence"
	 
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
		  List<Integer> b = new ArrayList<Integer>();//���浱ǰ���ȵ���С��
		 	
		  List<ArrayList<Integer>> LCS = new ArrayList<ArrayList<Integer>>();//����ݹ�״̬��
		 
		  
		 	b.add(p[0]);
		 	LCS.add(new ArrayList<Integer>());
		 	LCS.get(0).add(p[0]);
		 			 	
		 	for(int i=0; i<p.length; i++)
		 	{
		 		if(p[i] > b.get(b.size()-1))//p[n]������������󳤶ȼ�һ��b�����¼���ȣ�LCS�����¼��ѡ��ֵ
		 		{
		 			b.add(p[i]);
		 			LCS.add(new ArrayList<Integer>());	
		 			LCS.get(LCS.size()-1).add(p[i]);		 			
		 		}
		 		else//��ӵ��ʺϵ�λ��
		 		{
		 			int pos = bSearch(p[i],b);
		 	
		 			b.set(pos, p[i]);	
		 			
		 			if(pos == b.size()-1){//���λ���������ֱ��ȡ��ԭ����ֵ
		 				LCS.get(pos).set(0, p[i]);
		 			}
		 			else if(p[i] != LCS.get(pos).get(LCS.get(pos).size()-1)){//��������ѡ����		 				
		 				LCS.get(pos).add(p[i]);		 				
		 			}
		 		}
		 	}
		 	
		 	for(int i =LCS.size()-1; i>=0; i--){
		 		if(LCS.get(i).size() > 1){//�����ѡ����������ֵ��ѡ���������������ֵ
		 			int k=0;
		 			while(LCS.get(i).get(k) >= LCS.get(i+1).get(0)){
		 				k++;
		 			}
		 			
		 			LCS.get(i).set(0, LCS.get(i).get(k));
		 			
		 			while(LCS.get(i).size()>1){//�����Чֵ
		 				LCS.get(i).remove(LCS.get(i).size()-1);
		 			}
		 		}
		 	}		 	
		 System.out.println(b.size());	
		 System.out.println(LCS);
	 }
}
