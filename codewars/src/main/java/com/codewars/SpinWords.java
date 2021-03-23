package com.codewars;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpinWords {

    public String spinWords(String sentence) {
        StringBuffer sb = new StringBuffer();
        Stream<String> words = Arrays.stream(sentence.split(" "));
        words.forEach(item -> {
            if (item.length() >= 5) {
                for (int i = item.length() - 1; i >= 0; i--) {
                    sb.append(item.charAt(i));
                }
                sb.append(" ");
            } else {
                sb.append(item).append(" ");
            }

        });
        return sb.toString().strip();
    }

    public String bp(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(i -> i.length() > 4 ? new StringBuilder(i).reverse().toString() : i)
                .collect(Collectors.joining(" "));
    }
}
