package com.huangda7.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JUCLock {
    public static void main(String[] args) {
        Ticket1 ticket = new Ticket1();
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
class Ticket1{
    private int total=50;
    Lock lock = new ReentrantLock();
    public void sale(){
        lock.lock();
        try {
            if(total>0){
                //多线程同时操作同一个资源时存在的问题
                //1、当最后一张票时，如果多个线程同时进来，total会变成负数
                //2、同一个数字可能会被减多次
                System.out.println(Thread.currentThread().getName()+"卖出了"+total--+"票，剩余："+total);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
