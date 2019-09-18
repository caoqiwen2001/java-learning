package com.caoqiwen.learning.design.example10;

public class Builder {

    private String type;
    private String power;
    private String comfort;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getComfort() {
        return comfort;
    }

    public void setComfort(String comfort) {
        this.comfort = comfort;
    }


    public Builder type(String type) {
        this.type = type;
        return this;
    }

    public Builder power(String power) {
        this.power = power;
        return this;
    }

    public Builder comfort(String comfort) {
        this.comfort = comfort;
        return this;
    }


    public Car build() {
        return new Car(this);
    }


}
