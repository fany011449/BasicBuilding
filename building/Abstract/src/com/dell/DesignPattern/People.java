package com.dell.DesignPattern;

/**
 *  抽象類作為模板使用時建議使用final進行修飾，保護模板的用意
 */
public abstract class People {

    public final void write(){
        System.out.println("I am writing.");
        writeMain();
        System.out.println( "I am done writing." );
    }

    public abstract void writeMain();
}
