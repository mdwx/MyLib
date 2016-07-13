package com.example.src.ForTest;

import java.util.ArrayList;
import java.util.List;


public class MDKl {
	
	 public static void main(String[] args) {		 
		 List<Integer> Array = new ArrayList<Integer>();
		 int mod;
		 int key;
		 int T;
		 int i;
		 long cout = 0;
		 float sum = 0;
		 int king = 0;
		 
		 for(i=1; i<41; i++)
		 {
			 Array.add(i%10);
		 }
		 
		 while(true){
		 mod = (int)(Math.random()*20)+5;
		 
		 for(i=0; i< mod; i++)
		 {
			 key = (int)(Math.random()*39)+1;
			 T = (int)(Math.random()*(40-key))+1;
			 
			// System.out.println("key;"+key);
			// System.out.println("T"+T);
			 ArrayList<Integer>  Tarr = new ArrayList<Integer>(); 
			 while(T>0){
				 Tarr.add(Array.get(key+T-1));				 
				 T--;
			 }
			 while(T<Tarr.size()){
				 Array.set(key+T, Array.get(T));
				 T++;
			 }
			 T=0;
			 while(T<Tarr.size()){
				 Array.set(T, Tarr.get(T));
				 T++;
			 }		
		 }		 
	//	 System.out.println(Array);		 
		 for(i=0; i<40; i+=8){
			 sum++;
			 switch(Array.get(i)%4){
			 case 0:
				 if(Array.get(i) == 0){
					 king = 3;}
				 else{
					 king = 1;}
				 break;
			 case 1:
				 king = 0;
				 break;
			 case 2:
				 king = 3;
				 break;
			 case 3:
				 king = 2;				 
				 break;
			 default:
				 System.out.println("无效");
				 break;
			 }
			
			 if(Array.get(i+king) == Array.get(i+king+4)){
				 cout+=3;
			 }
			 else{				 
				 if(Array.get(i+(king+1)%4) == Array.get(i+(king+5)%4+4)){		
					 cout-=2;
				 }
				 else if((Array.get(i+king)+Array.get(i+king+4))%10 >= (Array.get(i+(king+1)%4)+Array.get(i+(king+5)%4+4))%10){
					 cout+=1;
				 }
				 else{
					 cout-=1;
				 }
				 
				 if(Array.get(i+(king+2)%4) == Array.get(i+(king+6)%4+4)){	
					 cout-=2;
				 }
				 else if((Array.get(i+king)+Array.get(i+king+4))%10 >= (Array.get(i+(king+2)%4)+Array.get(i+(king+6)%4+4))%10){
					 cout+=1;
				 }
				 else{
					 cout-=1;
				 }
				 
				 if(Array.get(i+(king+3)%4) == Array.get(i+(king+7)%4+4)){
					 cout-=2;
				 }				 
				 else if((Array.get(i+king)+Array.get(i+king+4))%10 >= (Array.get(i+(king+3)%4)+Array.get(i+(king+7)%4+4))%10){
					 cout+=1;
				 }
				 else{
					 cout-=1;
				 }				 				 
			 }
		 }
		 System.out.println("count:"+cout/sum+" sum:"+sum);
		 }	 
	 }
}
