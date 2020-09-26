package com.huangda7.thread.callable;

import java.util.concurrent.CountDownLatch;

//模拟所有线程出门后再关门
public class CountDownLatch1 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "go out");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("close door");
    }
}
