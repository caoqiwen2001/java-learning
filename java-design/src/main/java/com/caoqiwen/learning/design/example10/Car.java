package com.caoqiwen.learning.design.example10;

public class Car {

    private String size;
    private String wheel;
    private String maxSpeed;


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Car(Builder builder) {
        if ("紧凑车型".equals(builder.getType())) {
            this.size = "大小-紧凑车型";
        } else {
            this.size = "大小-其他车型";
        }

        if ("动力强劲".equals(builder.getPower())) {
            this.maxSpeed = "最大速度-强劲";
        } else {
            this.maxSpeed = "最大速度-较慢";
        }
    }


    public static void main(String[] args) {
        Car car = new Builder().power("动力强劲").build();
        System.out.println(car.getMaxSpeed());
    }

}
