package com.huangda7.advanced.volatiledemo;

public class VolatileDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        while (true) {
            if (MyThread.a == 1) {
                System.out.println("主线程读到了a=1");
                break;
            }
        }
    }
}

class MyThread extends Thread {
    public volatile static int a = 0;

    @Override
    public void run() {
        System.out.println("线程启动，休息2秒。。。");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("将2的值改为1");
        a = 1;
        System.out.println("线程结束....");
    }

}