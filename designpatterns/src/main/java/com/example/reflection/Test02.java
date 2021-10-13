package com.example.reflection;

import java.lang.annotation.ElementType;

/**
 * Created by yeyao on 2020/10/16
 * 哪些类型有Class对象
 */
public class Test02 {
    public static void main(String[] args) {

        Class c1 = Object.class; //类
        Class c2 = Comparable.class;//接口
        Class c3 = String[].class;//数组
        Class c4 = String[][].class;
        Class c5 = Override.class;  //注解
        Class c6 = ElementType.class;  //枚举
        Class c7 = Integer.class;  //基本数据类型
        Class c8 = void.class;  //void
        Class c9 = Class.class;  //class


        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);

        /**
         * 打印结果
         * class java.lang.Object
         * interface java.lang.Comparable
         * class [Ljava.lang.String;
         * class [[Ljava.lang.String;
         * interface java.lang.Override
         * class java.lang.annotation.ElementType
         * class java.lang.Integer
         * void
         * class java.lang.Class
         */
    }
}
