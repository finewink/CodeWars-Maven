package com.codewars;

import java.util.Arrays;

public class CreatePhoneNumber {
    public static String createPhoneNumber(int[] numbers) {
        String str = String.join("", Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new));
        return String.format("(%s) %s-%s", str.substring(0, 3), str.substring(3, 6), str.substring(6));
    }

    public static String bp1(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", numbers[0], numbers[1], numbers[2], numbers[3], numbers[4],
                numbers[5], numbers[6], numbers[7], numbers[8], numbers[9]);
    }

    public static String bp2(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", java.util.stream.IntStream.of(numbers).boxed().toArray());
    }
}