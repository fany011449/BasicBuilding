package com.dell.generics;


public class MyArrayList<E> {
    private Object[] arr = new Object[10];
    private int size;

    public MyArrayList() {
    }

    public boolean add(E e) {
        this.arr[this.size++] = e;
        return true;
    }

    public E get(int index) {
        return (E)this.arr[index];
    }
}
