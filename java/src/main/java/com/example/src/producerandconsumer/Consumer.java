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
                        	
                        	
                        	System.out.println( store.pop().getName()+"shift out form storage");
                       
                        }
                        System.out.println("Product:" + name + "Expenses:" + num  +"Still Number:"
                                + store.getList().size()+"]");                  
                    Thread.sleep(1000);               
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
