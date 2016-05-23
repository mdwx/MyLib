package com.example.src.ForTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arithmetic{
	
	//���ַ�����
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
	
	
	
	
	//��������
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
   
        // �����鳤��С��7�������ʹ�ò�������  
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
   
        // ѡ������
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
   
        // a,b�������ɨ�裬c,d�����Ҷ�ɨ��  
        int a = Start, b = a, c = Start + len - 1, d = c;  
        while (true) {  
            // �����ҵ�����pivot��Ԫ��  
            while (b <= c && list.get(b).compareTo(v) <= 0) {  
                // ��pivot��ͬ�Ľ��������  
                if (list.get(b).compareTo(v) == 0)  
                    swap(list, a++, b);  
                b++;  
            }  
            
            // �����ҵ�С��pivot��Ԫ��  
            while (c >= b && list.get(c).compareTo(v) >= 0) {  
                // ��pivot��ͬ�Ľ������Ҷ�  
                if (list.get(c).compareTo(v) == 0)  
                    swap(list, c, d--);  
                c--;  
            }  
            if (b > c)  
                break;  
            // �����ҵ���Ԫ��  
            swap(list, b++, c--);  
        }  
   
        // ����ͬ��Ԫ�ؽ������м�  
        int s, n = Start + len;  
        s = Math.min(a - Start, b - a);  
        vecswap(list, Start, b - s, s);  
        s = Math.min(d - c, n - d - 1);  
        vecswap(list, b, n - s, s);  
   
        // �ݹ����������  
        if ((s = b - a) > 1)  
        	QuickSort(list, Start, s + Start - 1);  
        if ((s = d - c) > 1)  
        	QuickSort(list, n - s, n - 1);  
    }

	public static<T> void  vecswap(List<T> list, int a, int b, int n) {//��������
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++, a++, b++)  
	        swap(list, a, b);  
	}
	public static<T> void swap(List<T> list,int a,int b){//����
		T Tem = list.get(a);		
		list.set(a, list.get(b));		
		list.set(b, Tem);
    }
	public static<T> void  vecswap(T[] list, int a, int b, int n) {//��������
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++, a++, b++)  
	        swap(list, a, b);  
	}
	public static<T> void swap(T[] list,int a,int b){//����
		T Tem = list[a];		
		list[a] = list[b];
		list[b] = Tem;		
    }
	public static <T extends Comparable<? super T> >  int med3(List<T> list, int a, int b, int c) {  //������ ,ȡ����
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


