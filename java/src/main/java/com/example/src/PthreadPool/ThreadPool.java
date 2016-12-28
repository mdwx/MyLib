package com.example.src.PthreadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Vince on 2016/12/28.
 * E_mail :  xhys01@163.com
 * Description :
 */

public class ThreadPool extends ThreadPoolExecutor{
    public ThreadPool(){
        super(Runtime.getRuntime().availableProcessors()/2 + 1, Runtime.getRuntime().availableProcessors()*2 + 2, 300, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100));
    }
    protected void beforeExecute(Thread t, Runnable r) {
        System.out.println("Task start."+ t.hashCode());
    }
    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        System.out.println("Task finished."+ r.hashCode());
    }

    @Override
    protected void terminated() {
        System.out.println("ThreadPool finished." + this.hashCode());
    }



public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = new ThreadPool();
        int a = 10;
        threadPool.execute(new Runnable(){
            @Override
            public void run() {
                System.out.println(a);
            }
        });
        Thread.sleep(3000);
        threadPool.shutdown();
    }


}
