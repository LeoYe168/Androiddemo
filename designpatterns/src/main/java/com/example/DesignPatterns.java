package com.example;

import com.example.inter.SubscriptionSubject;
import com.example.inter.WeiXinUser;

/**
 * Observer pattern demo
 */

public class DesignPatterns {

    public static void main(String[] args) {
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
