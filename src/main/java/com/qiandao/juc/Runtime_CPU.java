package com.qiandao.juc;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.LongStream;

public class Runtime_CPU {
    public static void main(String[] args) {
        //当前机器cpu核心数
//        System.out.println(Runtime.getRuntime().availableProcessors());

        long start = System.currentTimeMillis();
        long reduce = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, (a,b)->{
            System.out.println("并行流计算");
            return Long.sum(a, b);
        });
        long reduce1 = LongStream.rangeClosed(0L, 10_0000_0000).parallel().reduce(0, Long::sum);

        List<Integer> arrays = Collections.singletonList(10);
        arrays.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("消费型接口"+integer);
            }
        });
        arrays.forEach(obj->{System.out.println(obj);});
        arrays.forEach(System.out::println);

        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}

