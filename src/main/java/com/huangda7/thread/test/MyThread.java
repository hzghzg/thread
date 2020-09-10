package com.huangda7.thread.test;

public class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new MyThread(), "Thread" + i).start();//生成线程的顺序并不代表线程执行的顺序，可以看作这10个线程是同时生成的
            //哪个抢到资源哪个就先跑
        }
//        Thread.sleep(5);
    }
}

class Main implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {//可以将三个线程看作三条线，哪个抢到资源就会走那条线，实际上就是三个线程逻辑输出的任意排列
            System.out.println(Thread.currentThread().getName() + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new MyThread(), "Thread1").start();
        new Thread(new MyThread(), "Thread2").start();
        new Thread(new MyThread(), "Thread3").start();
    }
}