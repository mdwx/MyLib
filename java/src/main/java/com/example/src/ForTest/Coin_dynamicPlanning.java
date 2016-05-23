package com.example.src.ForTest;

/**
 * Created by Arales on 2016/5/23.
 */
public class Coin_dynamicPlanning {
    private int[] type;
    private int[] goal;

    public Coin_dynamicPlanning(){}
    public Coin_dynamicPlanning(int[] type,int goal) {
        this.type = type;
        this.goal = new int[goal+1];

        this.goal[0] = 0;
        for(int i=1; i<this.goal.length;i++){
            this.goal[i]=this.goal.length;
        }
        for(int i: this.type){
            this.goal[i] = 1;
        }
    }
    public int Sub_DP(int goal)
    {
        int key = Integer.MAX_VALUE;
        if (goal <= 0)return this.goal.length;
        if(this.goal[goal] != this.goal.length){
            return this.goal[goal];
        }
        else {
            for(int i:type){
                key = Integer.min(key,Sub_DP(goal - i) + 1);
            }
            this.goal[goal]= key;
            return key;
        }
    }

    public static void main(String args[]) {
        int[] type = {1,2,5};
        Coin_dynamicPlanning dp = new Coin_dynamicPlanning(type,1831);
        System.out.println(dp.Sub_DP(1831));
    }
}
