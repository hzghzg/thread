package com.huangda7.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class JUCLockVersion {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread1 myThread = new MyThread1();
        FutureTask futureTask = new FutureTask(myThread);
        new Thread(futureTask, "A").start();
        String returnValue = (String) futureTask.get();
        System.out.println(returnValue);
    }
}

class MyThread1 implements Callable<String>{
    @Override
    public String call() {
        System.out.println("callable exec");
        return "callable exec!";
    }
}
