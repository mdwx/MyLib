package com.example.src.producerandconsumer;

public class Consumer implements Runnable {
    private String name;
    private int num;
    private Storage<Product> store;

    public Consumer(String name, int num, Storage<Product> store) {
        super();
        this.name = name;
        this.num = num;
        this.store = store;
    }

    public void run() {
        while (true) {
            try {           
                        for (int i = 0; i < num; i++) {
                        	
                        	
                        	System.out.println( store.pop().getName()+"出库");   
                       
                        }
                        System.out.println("产品" + name + "共消费了" + num + "个产品"+"产品剩余:"
                                + store.getList().size()+"]");                  
                    Thread.sleep(1000);               
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
