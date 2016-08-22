package com.example.src.factory;

public class ItemA implements ItemBase{
    
	public static final String Path = ItemA.class.getName();
    private String name;
    private String age;
    
     
     @Override
     public String toString(){
      return "A name is :"+name+",A age is :"+age;
     
    }

    public String getName() {
    return name;
      }

      public void setName(String name) {
    this.name = name;
     }

     public String getAge() {
    return age;
     }

     public void setAge(String age) {
    this.age = age;
     }
    
}

