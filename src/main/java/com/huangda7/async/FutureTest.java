package com.huangda7.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException, ExecutionException {
        // 没有返回值的 runAsync 异步回调 //
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "runAsync=>Void");
        });
        System.out.println("1111");
        completableFuture.get(); // 获取阻塞执行结果
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "supplyAsync=>Integer");
            int i = 10 / 0;
            return 1024;
        });
        System.out.println(completableFuture1.whenComplete((t, u) ->
        {
            System.out.println("t=>" + t); // 正常的返回结果
            System.out.println("u=>" + u); // 错误信息： java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
        }).exceptionally((e) ->
        {
            System.out.println(e.getMessage());
            return 233; // 可以获取到错误的返回结果
        }).get());
    }
}