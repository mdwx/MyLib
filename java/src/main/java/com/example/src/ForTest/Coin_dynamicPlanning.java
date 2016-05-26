package com.example.src.ForTest;

import java.util.HashMap;

/**
 * Created by Arales on 2016/5/23.
 */
public class Coin_dynamicPlanning {
    private int[][] Mgoal;
    private int[] MKey;
    private HashMap<Integer,Integer> Map;
    public Coin_dynamicPlanning(){}
    public Coin_dynamicPlanning(HashMap<Integer,Integer>  Map, int goal) {
        this.Mgoal = new int[goal+1][Map.size()+1];
        this.MKey = new int[Map.size()+1];
        this.Map = Map;
        for(int i=0; i < goal+1; i++){
            this.Mgoal[i][0] = this.Mgoal.length;
        }
        int j = 0;
        for(java.util.Map.Entry<Integer,Integer> i:Map.entrySet()){
            if(i.getValue() > 0) {
                int key = i.getKey();
                this.Mgoal[key][0]=1;
                this.Mgoal[key][j+1] = 1;
            }
            this.MKey[j++] = i.getKey();
        }
    }
    public int Map_DP(int goal){
        int key = this.Mgoal.length+1;
        if (goal <= 0)return this.Mgoal.length;
        if(this.Mgoal[goal][0] >  this.Mgoal.length){
            return this.Mgoal.length + 1;
        }
        if(this.Mgoal[goal][0] < this.Mgoal.length){
            return this.Mgoal[goal][0];
        }
        else {
            int j = 0;
            int Top = 1;
            int type;
            int tem;
            for(java.util.Map.Entry<Integer,Integer> i:Map.entrySet()){
                type = i.getKey();
                tem = Map_DP(goal - type) + 1;
                if(tem < key) {
                    if(i.getValue() > this.Mgoal[goal - type][j+1]) {
                        key = tem;
                        Top = j;
                    }
                }
                j++;
            }
            this.Mgoal[goal][0]= key;
            if(key < this.Mgoal.length ) {
                for (int i = 0; i < Map.size(); i++) {
                    this.Mgoal[goal][i+1] = this.Mgoal[goal - MKey[Top]][i+1];
                }
                this.Mgoal[goal][Top+1]++;
            }
            return key;
        }
    }
    public static void main(String args[]) {
        HashMap<Integer,Integer> Map = new HashMap<>();

        Map.put(1,171);
        Map.put(2,3);
        Map.put(5,4);

        Map.put(10,171);
        Map.put(20,3);
        Map.put(50,4);

        Map.put(100,0);
        Map.put(200,0);
        Map.put(500,0);

        Map.put(1000,0);

        Coin_dynamicPlanning dp = new Coin_dynamicPlanning(Map,1831);
        for(int i=25; i<=1208; i++) {
            System.out.println(""+i+":"+dp.Map_DP(i));
        }
    }
}
