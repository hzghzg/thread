package com.huangda7.thread.lock;

public class EightLock {
    //1&2、只有一个对象，两个方法都加锁，第一个让他延时（放主线程里和方法里）
    //3、只有一个对象，加一个不加锁的方法
    //4、两个对象，分别调用两个同步方法（加锁）---锁的作用是对象，不同对象有不同锁
    //5&6、一个或任意个对象，两个同步静态方法，锁的是类，类只有一个，一个静态方法只有锁，另外一个静态方法只能等待，不管是哪个对象调用，因为类都是一个
    //7、一个对象，一个静态同步方法和一个普通同步方法，一个锁的是类，一个锁的对象，互不干扰
    //8、两个个对象，一个静态同步方法和一个普通同步方法，一个锁的是类，一个锁的对象，互不干扰

}
