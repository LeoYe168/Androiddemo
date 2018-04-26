package com.example.design.observer;

/**
 * Created by yeyao on 2017/8/29 上午11:50
 */

public class WeiXinUser implements Observer {

    private String name;

    public WeiXinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}
