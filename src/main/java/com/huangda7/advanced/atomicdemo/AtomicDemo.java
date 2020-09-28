package com.huangda7.advanced.atomicdemo;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread1.start();
        myThread2.start();
        Thread.sleep(1000);
        System.out.println("a的值为：" + MyThread.a);
    }
}

class MyThread extends Thread {
    public static AtomicInteger a = new AtomicInteger(0);
//    public static int a =0;

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
//            a++;
            a.getAndIncrement();
        }
        System.out.println("修改完毕");
    }
}
