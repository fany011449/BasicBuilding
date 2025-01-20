package com.dell.NoticeOfInterFace;

/*
    1. 接口與接口可以多個繼承，一個接口可以同時繼承多個接口
        // 類與類： 單繼承，一個類只能繼承一直接父類
        // 類與接口： 多實現，一個類可以同時現實多個接口
        // 接口與接口： 多繼承，一個接口可以同時繼承多個接口
    2. 一個接口繼承多個接口，如果多個接口中存在方法簽名衝突，則此時不支持多實現(implement)
    3. 一個類繼承了父類，又同時實現了接口，如果父類中和接口中有同名的方法，實現類會優先用父類的
    4. 一個類實現了多個接口，如果多個接口中存在同名的默認方法，可以不衝突，這個類重寫該方法既可
 */
public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.methodA2();
    }
}
/**
 *  1. 接口與接口可以多個繼承，一個接口可以同時繼承多個接口
 *         // 類與類： 單繼承，一個類只能繼承一直接父類
 *         // 類與接口： 多實現，一個類可以同時現實多個接口
 *         // 接口與接口： 多繼承，一個接口可以同時繼承多個接口
 */

interface A {
    void methodA();
}

interface B {
    void methodB();
}

interface C extends A, B {
    void methodC();
}

class D implements C {
    @Override
    public void methodA() {
        System.out.println("methodA");
    }

    @Override
    public void methodC() {

    }

    @Override
    public void methodB() {

    }
}

/**
 *  2. 一個接口繼承多個接口，如果多個接口中存在方法簽名衝突，則此時不支持多實現(implement)
 */
interface A1 {
    void methodA1();
}

interface B1 {
    String methodA1();
}

// 當被繼承的接口，擁有相同的方法名，但不同的返回值，此時既不支持多實現、亦不支持多繼承
//interface C1 extends A1, B1 {
//}
//
//class C11 implements A1, B1 {
//}

/**
 * 3. 一個類繼承了父類，又同時實現了接口，如果父類中和接口中有同名的方法，實現類會優先用父類的
 */

interface A2 {
    default void methodA2() {
        System.out.println("A2");
    }
}
class Animal {
    public void methodA2() {
        System.out.println("Animal");
    }
}

class Dog extends Animal implements A2 {
}

/**
 *  4. 一個類實現了多個接口，如果多個接口中存在同名的默認方法，可以不衝突，這個類重寫該方法既可
 */

interface A3 {
    default void methodA3() {
        System.out.println("A3");
    }
}

interface B3 {
    default void methodA3() {
        System.out.println("B3");
    }
}

class Dog3 implements A3, B3 {
    @Override
    public void methodA3() {
        System.out.println("Dog3");
        A3.super.methodA3();    // 找A3的method
        B3.super.methodA3();    // 找B3的method
    }
}