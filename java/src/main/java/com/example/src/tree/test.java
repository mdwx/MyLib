package com.example.src.tree;

/**
 * Created by Arales on 2016/5/20.
 */
public class test  {
    private int vuale;

    public test(){}
    public test(int v){
        this.vuale = v;
    }

    @Override
    public boolean equals(Object obj) {//that is bad idea to Override "equals"  http://www.cnblogs.com/kavlez/p/4185547.html
        if (obj instanceof test) {
            return (this.vuale == ((test) obj).vuale);
        }
        else {
            return (this == obj);
        }
    }
}
