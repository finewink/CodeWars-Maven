package com.codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StripComments {
    public static String stripComments(String text, String[] commentSymbols) {
        return Arrays.stream(text.split("\n"))
                .map(line -> line.replaceAll("[" + String.join("", commentSymbols) + "].*", "").stripTrailing())
                .collect(Collectors.joining("\n"));

    }
}
