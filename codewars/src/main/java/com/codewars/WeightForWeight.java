package com.codewars;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Comparator;

public class WeightForWeight {
    public static String orderWeight(String strng) {
        return Arrays.stream(strng.split(" ")).sorted((String a, String b) -> {
            int asum = Arrays.stream(a.split("")).mapToInt(Integer::parseInt).sum();
            int bsum = Arrays.stream(b.split("")).mapToInt(Integer::parseInt).sum();
            if (asum == bsum)
                return a.compareTo(b);
            else
                return Integer.compare(asum, bsum);
        }).collect(Collectors.joining(" "));
    }
}

class BP {
    public static String orderWeight(String string) {
        String[] split = string.split(" ");
        Arrays.sort(split, new Comparator<String>() {
            public int compare(String a, String b) {
                int aWeight = a.chars().map(c -> Character.getNumericValue(c)).sum();
                int bWeight = b.chars().map(c -> Character.getNumericValue(c)).sum();
                return aWeight - bWeight != 0 ? aWeight - bWeight : a.compareTo(b);
            }
        });
        return String.join(" ", split);
    }
}

class BP2 {

    public static String orderWeight(String strng) {
        return Arrays.stream(strng.split(" "))
                .sorted(Comparator.comparing(BP2::sumDigits).thenComparing(String::compareTo))
                .collect(Collectors.joining(" "));

    }

    private static Integer sumDigits(String s) {
        return s.chars().map(c -> c - 48).sum();
    }
}