package com.springboot.app2.util;

import java.util.Random;

public class RandomUtil {

    public static final int MAX_ID = 10000;

    public static long generateRandomLongValue() {
        return (long) new Random().nextInt(MAX_ID) + 1;
    }

}
