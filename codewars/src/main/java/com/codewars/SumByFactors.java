package com.codewars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SumByFactors {
    public static String sumOfDivided(int[] l) {
        int sum[] = Arrays.stream(l).boxed().collect((a, b) -> a + b);
        int[] nums = Arrays.copyOf(l, l.length + 1);
        // nums[nums.length - 1] = sum;
        int[] reverse = Arrays.stream(nums).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::valueOf)
                .toArray();

        ArrayList<int[]> list = new ArrayList<int[]>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : l) {
            for (int i = 2; i < num; i++) {
                if (num % i == 0 && isPrime(i)) {
                    for (int n : reverse) {
                        if (n % i == 0) {
                            // list.add(new int[] { i, n });
                            map.putIfAbsent(i, n);
                            break;
                        }
                    }
                }
            }
        }
        map.entrySet().stream().forEach(item -> list.add(new int[] { item.getKey(), item.getValue() }));
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Arrays.compare(o1, o2);
            }
        });

        return list.stream().map(item -> String.format("(%d %d)", item[0], item[1])).collect(Collectors.joining(""));
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
