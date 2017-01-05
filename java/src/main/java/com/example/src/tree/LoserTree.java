package com.example.src.tree;

import java.util.ArrayList;

public class LoserTree {
		
	public static void Adjust(int[] LoserTree, int Key,int length, int[] index){  
	    int Temp, t;     
	  
	    t = (Key + length) / 2;  
	    while(t > 0){ 
	        /* sָ���µ�ʤ�� */ 
	    	if(index[Key] != Integer.MAX_VALUE  && index[LoserTree[t]] != Integer.MAX_VALUE &&
	    			index[LoserTree[t]] != 0 && index[Key] != index[LoserTree[t]] && index[Key] != 0)
	    	System.out.println("������һ���Ƚ�"+index[Key]+","+index[LoserTree[t]]);
	        if(index[Key] > index[LoserTree[t]]){   /* LoserTree[t]��Key��Ҫ�ȽϵĽڵ㣬����һ�αȽϵ�ʧ���� */ 
	        	Temp = Key; 
	        	Key = LoserTree[t];  
	            LoserTree[t] = Temp; 
	        } 
	        t = t / 2; 
	    } 
	    LoserTree[0] = Key; 
	} 
	
	public static void Merge(Integer[] array,int low,int mid,int high)
	{
		int i=low,j=mid+1,k=0;
		Integer[] temp = new Integer[high-low+1];
		
		while(i<=mid&&j<=high)
		{
			temp[k] = array[i] < array[j] ? array[i++] : array[j++];
			k++;
		}
		
		while(i<=mid) 
		temp[k++] = array[i++];

		while(j<=high)
		temp[k++] = array[j++];

		
		for(i=0; i<high-low+1; i++)
		{
			array[low+i] = temp[i]; 
		}
	
	}	
	
	public static void Merge_Sort(Integer[] array)
	{
		int length; 
		int i;
		
		 if (array.length < 7) {  //����С��7�ò��뷨����	        	
	        	for (i = 0; i<array.length; i++) {  
	        		Integer t =array[i];  
	        	    int j = i;
	        	    for (; j > 0 && array[j-1]>t; j--) {  
	        	    	array[j] = array[j-1]; 
	        	    }  
	        	    array[j] = t; 
	        	}	        	
	            return;  
	        }  
	   
		 
		for(length=1;length<array.length;length*=2)
		{
			for(i=0;i+2*length-1<=array.length-1;i+=2*length)
				Merge(array,i,i+length-1,i+2*length-1);
			if(i+length<=array.length-1)//�����������ļ������к�һ������С��length
				Merge(array,i,i+length-1,array.length-1);
		}
	}

	public static void LoserSort(ArrayList<Integer[]> array)
	{
		int[] LoserTree = new int[array.size()];
		int[] index = new int[array.size()+1];
		ArrayList<Integer> outarray = new ArrayList<Integer>();
		int[] indexfile = new int[array.size()+1]; /* ָʾ��ǰ��С�ؼ������ڹ鲢�� */ 
		int i,k=0;
		
		for( i=0; i<array.size(); i++)
		{
			Merge_Sort(array.get(i));//��ÿһ�鲢������			
			index[i] = array.get(i)[0];
			indexfile[i] = 0;
			
			LoserTree[i] = array.size();//��ʼ��ʱ���ڵ�i�ĸ��ڵ�Ϊarray.size()
		}
		index[array.size()] = 0;//��ʼ��ʱ�����нڵ�ĸ��ڵ�Ϊarray.size()��ֵΪ0
		
		for( i = array.size()-1; i >= 0; --i){ 
	        Adjust(LoserTree, i,array.size(),index); 
	    } 
		
	
		i = 0;
		while(true){ 
	       	outarray.add(index[LoserTree[0]]);  
			indexfile[LoserTree[0]]++;
		
			if(indexfile[LoserTree[0]] <  array.get(LoserTree[0]).length)
			{			
				index[LoserTree[0]] = array.get(LoserTree[0])[indexfile[LoserTree[0]]];
				Adjust(LoserTree, LoserTree[0],array.size(),index);
			}
			else if (k < array.size())
			{
				index[LoserTree[0]] = Integer.MAX_VALUE;
				Adjust(LoserTree, LoserTree[0],array.size(),index);				
				k++;
				if(k == array.size())
				{
					break;
				}
			}
			else
			{				
				break;			
			}
	    }	
		System.out.println(outarray);
	}
	
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	
    	ArrayList<Integer[]>array = new ArrayList<Integer[]>();

//    	array.add(new Integer[]{1,2,3,4,5,6,7,8,9});
//    	array.add(new Integer[]{9,12,13,14,15,16,17,18,19});    	
//    	array.add(new Integer[]{20,112,113,114,115,116,117,118,119});
//    	array.add(new Integer[]{21,22,23,24,25,26,1127,1128,1129});
    	
    
    	
    	array.add(new Integer[]{2});
    	array.add(new Integer[]{3});
    	array.add(new Integer[]{4});
    	array.add(new Integer[]{5});
    	array.add(new Integer[]{6});
    	array.add(new Integer[]{7});
    	array.add(new Integer[]{8});
    	array.add(new Integer[]{9});
    	array.add(new Integer[]{10});
    	array.add(new Integer[]{23,56,11});
    	array.add(new Integer[]{1});
    	
    	LoserSort(array);
    }

}
