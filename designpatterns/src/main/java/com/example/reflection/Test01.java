package com.example.reflection;

/**
 * Created by yeyao on 2020/10/16
 * <p>
 * 测试Class对象的创建方式
 * 1.对象的 getClass()方式
 * 2.Class.forName()方式
 * 3.通过类名.CLASS方式
 */
public class Test01 {

    public static void main(String[] args) throws ClassNotFoundException {
        //方式1
        Student student = new Student("", "");
        Class aClass1 = student.getClass();
        System.out.println(aClass1.hashCode());

        //方式2
        Class aClass2 = Class.forName("com.example.reflection.Student");
        System.out.println(aClass2.hashCode());

        //方式3 类名字.CLASS方式
        Class aClass3 = Student.class;
        System.out.println(aClass3.hashCode());

    }
}

class Student {
    private String name;
    private String age;

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
