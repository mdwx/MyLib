package com.example.src.factory;
/** 
 * @author Vince  E-mail: xhys01@163.com
 * @version 创建时间：2015-6-9 下午2:42:35 
 * 类说明 
 */
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

