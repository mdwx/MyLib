package com.example.src.producerandconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {
    public static void main(String[] args) {
        Storage<Product> store = new Storage<>(10);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();		
        Producer p1 = new Producer("生产者一号", store);
        Producer p2 = new Producer("生产者二号", store);
        Producer p3 = new Producer("生产者三号", store);
        Consumer c1 = new Consumer("消费者一号", 4, store);
        Consumer c2 = new Consumer("消费者二号", 2, store);

        cachedThreadPool.execute(p1);
        cachedThreadPool.execute(p2);
        cachedThreadPool.execute(p3);
        cachedThreadPool.execute(c1);
        cachedThreadPool.execute(c2);

    }
}
