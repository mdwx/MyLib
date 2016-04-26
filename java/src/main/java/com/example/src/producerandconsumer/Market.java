package com.example.src.producerandconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {
    public static void main(String[] args) {
        Storage<Product> store = new Storage<Product>(10);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();		
        Producer p1 = new Producer("生产�?1�?", store);
        Producer p2 = new Producer("生产�?2�?", store);
        Producer p3 = new Producer("生产�?3�?", store);
        Consumer c1 = new Consumer("消费�?1�?", 4, store);
        Consumer c2 = new Consumer("消费�?2�?", 2, store);

        cachedThreadPool.execute(p1);
        cachedThreadPool.execute(p2);
        cachedThreadPool.execute(p3);
        cachedThreadPool.execute(c1);
        cachedThreadPool.execute(c2);

    }
}
