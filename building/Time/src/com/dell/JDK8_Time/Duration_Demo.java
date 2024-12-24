package com.dell.JDK8_Time;

import java.time.Duration;
import java.time.LocalDateTime;

public class Duration_Demo {
    public Duration_Demo() {
    }

    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.of(2025, 11, 11, 11, 10, 10);
        LocalDateTime end = LocalDateTime.of(2025, 11, 11, 11, 13, 13);
        Duration duration = Duration.between(start, end);
        System.out.println(duration.toDays());
        System.out.println(duration.toHours());
        System.out.println(duration.toSeconds());
        System.out.println(duration.toMinutes());
        System.out.println(duration.toMillis());
        System.out.println(duration.toNanos());
    }
}
