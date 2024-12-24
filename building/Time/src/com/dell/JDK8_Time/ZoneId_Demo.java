package com.dell.JDK8_Time;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneId_Demo {
    public ZoneId_Demo() {
    }

    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId.getId());
        System.out.println(ZoneId.getAvailableZoneIds());
        ZoneId zoneId1 = ZoneId.of("America/New_York");
        ZonedDateTime now = ZonedDateTime.now(zoneId1);
        System.out.println(now);
    }
}
