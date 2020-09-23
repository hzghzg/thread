package com.huangda7.thread.threadnotify;

public class SynchronizeVersion {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread((()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }),"A").start();
        new Thread((()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }),"B").start();

    }
}
class Data{
    private int num=0;
    public synchronized void increment() throws InterruptedException {
        while(num!=0){
            //等待
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"=>"+num);
        //通知其他线程该操作结束
        this.notifyAll();
    }
    public synchronized void decrement() throws InterruptedException {
        while(num==0){
            //等待
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"=>"+num);
        //通知其他线程该操作结束
        this.notifyAll();
    }
}
