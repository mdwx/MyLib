package com.example.src.ForTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arithmetic{
	
	//二分法查找
	public static<T extends Comparable<? super T> > int BinarySearch(List<T> array, T key)
	{
		return Arithmetic.BinarySearch(array, 0, array.size(), key);
	}
	
	public static<T extends Comparable<? super T> > int BinarySearch(T[] array, int start, int end, T key)
	{	
		List<T> stooges = Arrays.asList(array);
		return Arithmetic.BinarySearch(stooges, start, end, key);
	}
	
	public static<T extends Comparable<? super T> > int BinarySearch(T[] array, T key)
	{	
		List<T> stooges = Arrays.asList(array);
		return Arithmetic.BinarySearch(stooges, 0, stooges.size(), key);
	}
	
	public static<T extends Comparable<? super T> > int BinarySearch(List<T> array, int start, int end, T key)
	{		
    	int low;
    	int high;   	
    	int guess;
       	
    	if(array == null || start>end || start > array.size()-1 || end < 0)
    	{
    		return -1;
    	}  
    	
    	start = start < 0 ? 0 : start;
    	low  = start-1;
    	
    	end = end > array.size()-1 ? array.size()-1 : end; 
    	high = end+1; 
    	
    	
        while (high - low > 1) {
            guess = ((high - low)>>1)  + low;

            if (array.get(guess).compareTo(key) < 0)
			{
				low = guess;
			}
            else
			{
				high = guess;
			}
        }

        if (high == end +1 )
        {
        	 return ~(end +1 );
        }           
        else if (array.get(high).compareTo(key) == 0)
        {
        	 return high;
        }
        else
        {
        	return ~high;		
        }      
	}
	
	
	
	
	//快速排序
	public static<T extends Comparable<? super T> > void QuickSort(List<T> list) { 
		QuickSort(list,0,list.size()-1);	
	}
	
	public static<T extends Comparable<? super T> > void QuickSort(T[] array) { 
		
		List<T> stooges = Arrays.asList(array);
		Arithmetic.QuickSort(stooges, 0, stooges.size()-1);
	}
	
	public static<T extends Comparable<? super T> > void QuickSort(T[] array,int Start, int End) { 
		
		List<T> stooges = Arrays.asList(array);
		Arithmetic.QuickSort(stooges, Start, End);			
	}
	
	public static<T extends Comparable<? super T> > void QuickSort(List<T> list, int Start, int End) { 
		
        if (Start >= End)  
            return;  
   
        // 在数组长度小于7的情况下使用插入排序  
        if (End - Start + 1 < 7) {  
        	
        	for (int i = Start; i <= End; i++) {  
        	    T t = list.get(i);  
        	    int j = i;
        	    for (; j > Start && list.get(j-1).compareTo(t) > 0; j--) {  
        	        list.set(j, list.get(j-1));  
        	    }  
        	    list.set(j, t);  
        	}
        	
            return;  
        }  
   
        // 选择中数
        int len = End - Start + 1;  
        int m = Start + (len >> 1);  
        if (len > 7) {  
            int l = Start;  
            int n = Start + len - 1;  
            if (len > 40) {  
                int s = len / 8;  
                l = med3(list, l, l + s, l + 2 * s);  
                m = med3(list, m - s, m, m + s);  
                n = med3(list, n - 2 * s, n - s, n);  
            }  
            m = med3(list, l, m, n);  
        }  
   
        T v = list.get(m);  
   
        // a,b进行左端扫描，c,d进行右端扫描  
        int a = Start, b = a, c = Start + len - 1, d = c;  
        while (true) {  
            // 尝试找到大于pivot的元素  
            while (b <= c && list.get(b).compareTo(v) <= 0) {  
                // 与pivot相同的交换到左端  
                if (list.get(b).compareTo(v) == 0)  
                    swap(list, a++, b);  
                b++;  
            }  
            
            // 尝试找到小于pivot的元素  
            while (c >= b && list.get(c).compareTo(v) >= 0) {  
                // 与pivot相同的交换到右端  
                if (list.get(c).compareTo(v) == 0)  
                    swap(list, c, d--);  
                c--;  
            }  
            if (b > c)  
                break;  
            // 交换找到的元素  
            swap(list, b++, c--);  
        }  
   
        // 将相同的元素交换到中间  
        int s, n = Start + len;  
        s = Math.min(a - Start, b - a);  
        vecswap(list, Start, b - s, s);  
        s = Math.min(d - c, n - d - 1);  
        vecswap(list, b, n - s, s);  
   
        // 递归调用子序列  
        if ((s = b - a) > 1)  
        	QuickSort(list, Start, s + Start - 1);  
        if ((s = d - c) > 1)  
        	QuickSort(list, n - s, n - 1);  
    }

	public static<T> void  vecswap(List<T> list, int a, int b, int n) {//批量交换
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++, a++, b++)  
	        swap(list, a, b);  
	}
	public static<T> void swap(List<T> list,int a,int b){//交换
		T Tem = list.get(a);		
		list.set(a, list.get(b));		
		list.set(b, Tem);
    }
	public static<T> void  vecswap(T[] list, int a, int b, int n) {//批量交换
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++, a++, b++)  
	        swap(list, a, b);  
	}
	public static<T> void swap(T[] list,int a,int b){//交换
		T Tem = list[a];		
		list[a] = list[b];
		list[b] = Tem;		
    }
	public static <T extends Comparable<? super T> >  int med3(List<T> list, int a, int b, int c) {  //三个数 ,取中数
	    return list.get(a).compareTo(list.get(b)) < 0? (list.get(b).compareTo(list.get(c)) < 0?  b : list.get(a).compareTo(list.get(c))<0? c : a)  
	            : list.get(b).compareTo(list.get(c)) > 0 ? b : list.get(a).compareTo(list.get(c)) > 0? c : a;  
	}
	
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	
    	ArrayList<Integer> a = new ArrayList<>();
    	
    	Float[] b = new Float[100];
     
    	
    	for(int i=0; i<100; i++)
    	{
    		a.add(i);  
    		b[i] = (float) i;
    		
    	}    	
		  System.out.println(""+Arithmetic.BinarySearch(a,10));
		  System.out.println(""+Arithmetic.BinarySearch(b,(float)2));
		  
		  Arithmetic.QuickSort(a);
		  Arithmetic.QuickSort(b);
		  System.out.println(""+a);

		for(int i=0; i<100; i++)
		{
		  System.out.print(b[i]+",");	    		
		} 
	}
 }	


