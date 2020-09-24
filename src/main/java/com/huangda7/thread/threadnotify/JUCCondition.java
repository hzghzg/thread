package com.huangda7.thread.threadnotify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JUCCondition {
    public static void main(String[] args) {
        Data2 data2 = new Data2();
        new Thread((()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data2.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }),"A").start();
        new Thread((()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data2.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }),"B").start();
        new Thread((()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data2.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }),"C").start();
    }
}
class Data2 {
    private int num = 1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void printA() throws InterruptedException {
        lock.lock();
        try {
            while (num != 1) {
                //等待
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>" + "AAAAAAAAAA");
            num=2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public  void printB() throws InterruptedException {
        lock.lock();
        try {
            while (num != 2) {
                //等待
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>" + "BBBBBBB");
            num=3;
            //通知其他线程该操作结束
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public  void printC() throws InterruptedException {
        lock.lock();
        try {
            while (num != 3) {
                //等待
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "=>" + "CCCCCCCC");
            num=1;
            //通知其他线程该操作结束
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


