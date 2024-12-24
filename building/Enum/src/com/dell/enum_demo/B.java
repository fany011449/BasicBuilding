package com.dell.enum_demo;

public enum B {
    X {
        public void go() {
        }
    },
    Y("yoyo") {
        public void go() {
            System.out.println(this.getName() + "gogo");
        }
    };

    private String name;

    public abstract void go();

    private B() {
    }

    private B(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}