package com.example;

import com.example.algorithm.queue.QueueArray;

/**
 * Created by yeyao on 2018/4/26 下午2:35
 */
public class Test {
    public static void main(String[] args) {
////        观察者设计模式demo
//        SubscriptionSubject mSubscriptionSubject = new SubscriptionSubject();
//        //创建微信用户
//        WeiXinUser user1 = new WeiXinUser("one");
//        WeiXinUser user2 = new WeiXinUser("two");
//        WeiXinUser user3 = new WeiXinUser("three");
//        //订阅公众号
//        mSubscriptionSubject.attach(user1);
//        mSubscriptionSubject.attach(user2);
//        mSubscriptionSubject.attach(user3);
//        //公众号更新发出消息给订阅的微信用户
//        mSubscriptionSubject.notify("hello world");


        QueueArray<Integer> se = new QueueArray<>();
        se.insertObject(1);
        se.insertObject(2);
        se.insertObject(3);
        se.insertObject(4);
        System.out.println("原始容量下，队列元素为");
        se.printAll();

        System.out.println("队列满后，继续增加元素5");
        se.insertObject(5);
        se.printAll();

        se.remove();
        // System.out.println("删除队列首元素1，队列首元素为：" + se.[se.first]);

        se.remove();

        se.insertObject(6);
        se.insertObject(7);
        se.insertObject(8);
        se.insertObject(9);
        se.insertObject(10);
        se.insertObject(11);
        se.printAll();
        se.insertObject(12);
        se.printAll();

        se.insertObject(13);
        se.insertObject(14);
        se.insertObject(15);
        se.printAll();

    }
}
