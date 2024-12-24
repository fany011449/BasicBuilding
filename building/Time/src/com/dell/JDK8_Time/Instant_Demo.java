package com.dell.JDK8_Time;

import java.time.Instant;

public class Instant_Demo {
    public Instant_Demo() {
    }

    public static void main(String[] args) {
        Instant now = Instant.now();
        long second = now.getEpochSecond();
        System.out.println(second);
        int nano = now.getNano();
        System.out.println(nano);
    }
}
