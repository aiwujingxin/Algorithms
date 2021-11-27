package com.example.demo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * @author jingxinwu
 * @date 2021-07-28 4:51 下午
 */
public class Time {

    public static void main(String[] args) {
        System.out.println(getSecondNumber());
    }


    private static int getSecondNumber() {
        LocalTime midnight = LocalTime.MIDNIGHT;
        LocalDate today = LocalDate.now();
        LocalDateTime todayMidnight = LocalDateTime.of(today, midnight);
        LocalDateTime tomorrowMidnight = todayMidnight.plusDays(1);
        long seconds = TimeUnit.NANOSECONDS
                .toSeconds(Duration.between(LocalDateTime.now(), tomorrowMidnight).toNanos());
        return (int) seconds;

    }
}


