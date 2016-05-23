package com.example.src.ForTest;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Arales on 2016/5/23.
 */
public class DistinctCount {

    public DistinctCount(){}
    public static int Count(int[] array) {
        Set set = new HashSet<Integer>();
        for(int i=0; i<array.length ;i++)
        {
            set.add(array[i] < 0 ? -array[i] : array[i]);
        }
        return set.size();
    }
    public static void  main(String args[]){

        int[] array = {0, -5 ,5, 2 ,1 ,3, 12};
        System.out.println(Count(array));
    }
}
