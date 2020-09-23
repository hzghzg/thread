package com.huangda7.thread.lock;

public class Synchronized {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                ticket.sale();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                ticket.sale();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                ticket.sale();
            }
        },"C").start();
    }
}
class Ticket{
    private int total=50;
    public synchronized void sale(){
        if(total>0){
            //多线程同时操作同一个资源时存在的问题
            //1、当最后一张票时，如果多个线程同时进来，total会变成负数
            //2、同一个数字可能会被减多次
            System.out.println(Thread.currentThread().getName()+"卖出了"+total--+"票，剩余："+total);
        }
    }
}