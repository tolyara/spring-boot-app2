package com.springboot.app2.util.fortest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StaticUtils {

    public static final String NAME = "StaticUtils-name";

    private StaticUtils() {}

    public static List<Integer> range(int start, int end) {
        return IntStream.range(start, end)
                .boxed()
                .collect(Collectors.toList());
    }

    public static String name() {
        return NAME;
    }

}
