package com.example.src.producerandconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {
    public static void main(String[] args) {
        Storage<Product> store = new Storage<Product>(10);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();		
        Producer p1 = new Producer("ç”Ÿäº§è€?1å?", store);
        Producer p2 = new Producer("ç”Ÿäº§è€?2å?", store);
        Producer p3 = new Producer("ç”Ÿäº§è€?3å?", store);
        Consumer c1 = new Consumer("æ¶ˆè´¹è€?1å?", 4, store);
        Consumer c2 = new Consumer("æ¶ˆè´¹è€?2å?", 2, store);

        cachedThreadPool.execute(p1);
        cachedThreadPool.execute(p2);
        cachedThreadPool.execute(p3);
        cachedThreadPool.execute(c1);
        cachedThreadPool.execute(c2);

    }
}
