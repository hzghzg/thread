package com.huangda7.funinterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Demo {
    public static void main(String[] args) {
        //函数型接口------------------有参数有返回值
        //        Function<String, String> function = new Function<String, String>() {
//            @Override
//            public String apply(String str) {
//                return str;
//            }
//        };
//        Function<String, String> function = (str) -> {
//            return str;
//        };
//        System.out.println(function.apply("asd"));
//    }
//-----------------------------------------断定型接口，返回值是boolean值
        // 判断字符串是否为空 //
//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String str) {
//                return str.isEmpty();
//            }
//        };
        Predicate<String> predicate = (str) -> {
            return str.isEmpty();
        };
        System.out.println(predicate.test(""));

        //-----------------------------------------消费型接口
//    Consumer<String> consumer = new Consumer<String>() {
//        @Override
//        public void accept(String str) {
//            System.out.println(str);
//        }
//    };
//        Consumer<String> consumer = (str) -> {
//            System.out.println(str);
//        };
//        consumer.accept("sdadasd");
        //-----------------------------------------供给型接口
//        Supplier supplier = new Supplier<Integer>() {
//            @Override
//            public Integer get() {
//                System.out.println("get()");
//                return 1024;
//            }
//        };
        Supplier supplier = () -> {
            return 1024;
        };
        System.out.println(supplier.get());
    }
}
