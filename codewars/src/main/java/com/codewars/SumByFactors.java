package com.codewars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SumByFactors {
    public static String sumOfDivided(int[] l) {
        ArrayList<String> list = new ArrayList<String>();
        System.out.println(Arrays.stream(l).map(item -> Math.abs(item)).max().getAsInt() + 1);
        for (int i = 2; i < Arrays.stream(l).map(item -> Math.abs(item)).max().getAsInt() + 1; i++) {
            for (int num : l) {
                if (num % i == 0 && isPrime(i)) {
                    final int prime = i;
                    list.add(String.format("(%d %d)", i, Arrays.stream(l).filter(item -> item % prime == 0).sum()));
                    break;
                }
            }
        }

        return list.stream().collect(Collectors.joining(""));

    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < num / 2 + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
