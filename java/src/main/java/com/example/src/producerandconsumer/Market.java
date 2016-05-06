package com.example.src.producerandconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {
    public static void main(String[] args) {
        Storage<Product> store = new Storage<>(10);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();		
        Producer p1 = new Producer("������һ��", store);
        Producer p2 = new Producer("�����߶���", store);
        Producer p3 = new Producer("����������", store);
        Consumer c1 = new Consumer("������һ��", 4, store);
        Consumer c2 = new Consumer("�����߶���", 2, store);

        cachedThreadPool.execute(p1);
        cachedThreadPool.execute(p2);
        cachedThreadPool.execute(p3);
        cachedThreadPool.execute(c1);
        cachedThreadPool.execute(c2);

    }
}
