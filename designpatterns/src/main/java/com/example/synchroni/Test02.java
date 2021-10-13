package com.example.synchroni;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * Created by yeyao on 2020/10/19
 */
public class Test02 {

    private static int m = 0;

    private static AtomicInteger n = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread[] thread = new Thread[100];
        final CountDownLatch latch = new CountDownLatch(thread.length);
        final Object o = new Object();
        for (int i = 0; i < thread.length; i++) {
            thread[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (o) {    //synchronized实现加锁
                        for (int j = 0; j < 1000; j++) {
                            m++;
                        }
                    }

                    for (int k = 0; k < 1000; k++) {
                        m++;
                        n.incrementAndGet(); //用到了自旋锁，也称为CAS
                    }

                    latch.countDown();
                }
            });
        }
        Arrays.stream(thread).forEach(new Consumer<Thread>() {
            @Override
            public void accept(Thread thread) {
                thread.start();
            }
        });
        latch.await();
        System.out.println(m);
        System.out.println(n);
    }
}
