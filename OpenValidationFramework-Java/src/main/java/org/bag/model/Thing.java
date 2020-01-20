package org.bag.model;

public class Thing {
    private double number;
    private String name;

    public Thing() {
    }

    public Thing(int num, String description) {
        number = num;
        name = description;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}