package com.huangda7.thread.ThreadPool;

import java.util.concurrent.*;

public class ThreeMethod {
    public static void main(String[] args) {
        //三大方法
        ExecutorService threadPool = Executors.newSingleThreadExecutor();// 单个线程
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);// 创建一个固定的线程池的大小
//        ExecutorService threadPool = Executors.newCachedThreadPool(); // 可伸缩的，遇强则强，遇弱则弱
        try {
            for (int i = 0; i < 100; i++) {
                // 使用了线程池之后，使用线程池来创建线程
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {            // 线程池用完，程序结束，关闭线程池            threadPool.shutdown();        }
        }
    }
//七大参数
//    public ThreadPoolExecutor(int corePoolSize, // 核心线程池大小
//                              int maximumPoolSize, // 大核心线程池大小
//                              long keepAliveTime, // 超时了没有人调用就会释放
//                              TimeUnit unit, // 超时单位
//                              BlockingQueue<Runnable> workQueue, // 阻塞队列
//                              ThreadFactory threadFactory, // 线程工厂：创建线程的，一般 不用动
//                              RejectedExecutionHandler handle // 拒绝策略
//    ) {
//        if (corePoolSize < 0 || maximumPoolSize <= 0 || maximumPoolSize < corePoolSize || keepAliveTime < 0)
//            throw new IllegalArgumentException();
//        if (workQueue == null || threadFactory == null || handler == null) throw new NullPointerException();
//        this.acc = System.getSecurityManager() == null ? null : AccessController.getContext();
//        this.corePoolSize = corePoolSize;
//        this.maximumPoolSize = maximumPoolSize;
//        this.workQueue = workQueue;
//        this.keepAliveTime = unit.toNanos(keepAliveTime);
//        this.threadFactory = threadFactory;
//        this.handler = handler;
//    }
//四大拒绝策略
// 自定义线程池！工作 ThreadPoolExecutor
    /**
ExecutorService threadPool = new ThreadPoolExecutor(2, 5, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
    //队列满了，尝试去和 早的竞争，也不会抛出异常！
    try

    {
        // 大承载：Deque + max
        // 超过 RejectedExecutionException
        for (int i = 1; i <= 9; i++) {
            // 使用了线程池之后，使用线程池来创建线程
            // threadPool.execute(()->{                    System.out.println(Thread.currentThread().getName()+" ok");                });

        }
    }catch(
    Exception e)

    {
        e.printStackTrace();
    }finally

    {
        // 线程池用完，程序结束，关闭线程池
        threadPool.shutdown();
    }
    **/
}

