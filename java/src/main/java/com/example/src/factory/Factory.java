package com.example.src.factory;


public class Factory {
    
    public static ItemBase createObj(String className) throws Exception{
            return (ItemBase)Class.forName(className).newInstance();
}
}