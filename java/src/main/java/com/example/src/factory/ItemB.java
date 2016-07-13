package com.example.src.factory;
/** 
 * @author Vince  E-mail: xhys01@163.com
 * @version 创建时间：2015-6-9 下午2:43:23 
 * 类说明 
 */
public class ItemB implements ItemBase{
    
	public static final String Path = ItemB.class.getName();
    private String name;
    private String age;
    
     
     @Override
     public String toString(){
      return "B name is :"+name+",B age is :"+age;
     
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
