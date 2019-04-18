package com;

public class Cat extends Animal {
    @Override
    public void run() {
        System.out.println("Cat");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
