package com.example.other.idea;

/**
 * Created by yeyao on 2018/4/27 下午6:06
 * java 强引用弱引用demo
 */
public class Car {
    private double price;
    private String colour;

    public Car(double price, String colour) {
        this.price = price;
        this.colour = colour;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String toString() {
        return colour + "car costs $" + price;
    }
}
