package com.example;

import com.example.design.observer.SubscriptionSubject;
import com.example.design.observer.WeiXinUser;

/**
 * Created by yeyao on 2018/4/26 下午2:35
 */
public class Test {
    public static void main(String[] args) {
//        观察者设计模式demo
        SubscriptionSubject mSubscriptionSubject = new SubscriptionSubject();
        //创建微信用户
        WeiXinUser user1 = new WeiXinUser("one");
        WeiXinUser user2 = new WeiXinUser("two");
        WeiXinUser user3 = new WeiXinUser("three");
        //订阅公众号
        mSubscriptionSubject.attach(user1);
        mSubscriptionSubject.attach(user2);
        mSubscriptionSubject.attach(user3);
        //公众号更新发出消息给订阅的微信用户
        mSubscriptionSubject.notify("hello world");
    }
}
