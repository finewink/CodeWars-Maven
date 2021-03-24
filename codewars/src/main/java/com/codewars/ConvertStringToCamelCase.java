package com.codewars;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertStringToCamelCase {

    public static String toCamelCase(String s) {
        if (s.isEmpty())
            return "";
        String camel = String.join("", Arrays.stream(s.split("[-_]"))
                .map(item -> item.substring(0, 1).toUpperCase() + item.substring(1)).toArray(String[]::new));
        return s.substring(0, 1) + camel.substring(1);
    }

    static String bp1(String s) {
        Matcher m = Pattern.compile("[_|-](\\w)").matcher(s);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, m.group(1).toUpperCase());
        }
        return m.appendTail(sb).toString();
    }

    static String bp2(String str) {
        String[] words = str.split("[-_]");
        return Arrays.stream(words, 1, words.length).map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .reduce(words[0], String::concat);
    }
}
