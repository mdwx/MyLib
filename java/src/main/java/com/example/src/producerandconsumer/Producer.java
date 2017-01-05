package com.example.src.producerandconsumer;


public class Producer implements Runnable {
    private String name;
    private Storage<Product> store;

    public Producer(String name, Storage<Product> store) {
        super();
        this.name = name;
        this.store = store;
    }


    public void run() {
        while (true) {               
                        Product p = new Product("产品" + (int) (Math.random() * 1000), (int) (Math
                                .random() * 1000));
                        store.push(p);
                        System.out.println("产品" + name + "共生产了产品" + p.toString() + "还有库存量"
                                + store.getList().size());                  
                    try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
               
        }
    }
}
