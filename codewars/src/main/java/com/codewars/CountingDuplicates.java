package com.codewars;

import java.util.HashMap;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < text.length(); i++) {
            map.put(text.toLowerCase().charAt(i), map.getOrDefault(text.toLowerCase().charAt(i), 0).intValue() + 1);
        }

        map.entrySet().stream().filter(p -> p.getValue().intValue() > 1).count();

        return (int) map.entrySet().stream().filter(p -> p.getValue().intValue() > 1).count();
    }
}
