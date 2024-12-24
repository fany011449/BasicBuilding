package com.dell.enum_demo;


public enum A {
    X,
    Y,
    Z;

    private String name;

    private A() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
