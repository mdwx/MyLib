package com.example.src.fonsview;

/**
 * Created by Arales on 2016/7/26.
 * E_mail :  xhys01@163.com
 * Description :
 */
public abstract class PacketCallBack {
    private Object param = null;

   public PacketCallBack( ){super();}
   public PacketCallBack(Object param){
        this.param = param;
    }
   public Object getParam(){
        return param;
    }
   public abstract void CallBack(Object param, Object packetData);
}
