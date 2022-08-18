package com.qiandao.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class aomic {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("开启新线程"+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ReentrantLock lock = new ReentrantLock();
            lock.lock();
            System.out.println("加锁了。。。");
            System.out.print(IntStream.range(0, 10).parallel().reduce(0, Integer::sum));
            lock.unlock();
        }).start();
    }
}
