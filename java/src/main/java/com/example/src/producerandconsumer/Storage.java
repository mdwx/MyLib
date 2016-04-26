package com.example.src.producerandconsumer;

import java.util.concurrent.LinkedBlockingQueue;

public class Storage<T> {
    private LinkedBlockingQueue<T> list;
    private int MAX_SIZE;  

    public Storage() {super();}
    public Storage(int Max) {
        super();
        MAX_SIZE = Max;
        list = new LinkedBlockingQueue<T>(MAX_SIZE);
    }

    public  void push(T p) {
    	try {
			list.put(p);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public  T pop() {    
    	
    	try {
		 	return list.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    	
    }

    public  boolean isEmpty() {
        return list.size() == 0 ? true : false;
    }

    public  boolean isFull() {
        return list.size() == MAX_SIZE ? true : false;
    }

    public  LinkedBlockingQueue<T> getList() {
        return list;
    }

    public int size() {
        return list.size();
    }
    
    public int getMAX_SIZE()
	{
		return MAX_SIZE;
	}
}
