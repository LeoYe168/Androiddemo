package com.example.synchroni;

/**
 * Created by yeyao on 2020/10/19
 *
 * synchronized 锁的是谁
 */
public class TestSynchronized {
    public static void main(String[] args) {
        Object o = new Object();
        synchronized (o) {  //锁的是对象o

        }
    }

    public synchronized void TestYe1() {
        //锁的是当前对象，相当如以下代码
        synchronized (this) {

        }
    }

    public static synchronized void testYe() {
        //锁的是class对象 相当如以下代码
        synchronized (TestSynchronized.class) {

        }
    }

}
