package com.huangda7.advanced.pessimisticlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PessimisticLock {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket,"A");
        Thread thread2 = new Thread(ticket,"B");
        Thread thread3 = new Thread(ticket,"C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Ticket implements Runnable {
    private int ticker = 100;
    private Lock lock=new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            lock.lock();
//            synchronized (this) {
            try {
                if (ticker > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"正在卖"+ticker);
                    ticker--;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
//            }
        }
    }
}
