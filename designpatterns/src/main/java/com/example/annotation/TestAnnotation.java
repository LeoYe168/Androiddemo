package com.example.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by yeyao on 2020/10/15
 * <p>
 * 注解
 * 内置注解 + 元注解 + 自定义注解
 */
@YeAnnotation(age = {"ye", "yao"}, name = "你好")
public class TestAnnotation {
    public static void main(String[] args) {
        System.out.println("搞定了很多");
    }

    @TestYeAnnotation(sex = "男")
    public void testMethod() {

    }
}

/**
 * 自定义注解
 */
@Target({ElementType.TYPE, ElementType.METHOD}) //作用域
@Retention(RetentionPolicy.RUNTIME)   //哪个级别可用
@Documented     //是否生成到DOC文档里
@Inherited
        //是否继承
@interface YeAnnotation {
    String name() default "叶瑶"; //定义参数

    String[] age();

}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface TestYeAnnotation {
    String sex();
}
