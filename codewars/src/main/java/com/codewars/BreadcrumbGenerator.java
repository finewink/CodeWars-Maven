package com.codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BreadcrumbGenerator {
    public static String generate_bc(String url, String separator) {
        String[] urlStrings = url.replaceFirst("http[s]?://", "").split("/");
        String[] paths = Arrays.stream(urlStrings, 1, urlStrings.length).filter(item -> !item.matches("index[.].*"))
                .map(item -> item.substring(0, item.contains("#") ? item.indexOf("#") : item.length()))
                .map(item -> item.substring(0, item.contains("?") ? item.indexOf("?") : item.length()))
                .map(item -> item.substring(0, item.contains(".") ? item.indexOf(".") : item.length()))
                .filter(item -> !"".equals(item)).toArray(String[]::new);

        StringBuffer locations = new StringBuffer("/");
        StringBuffer output = new StringBuffer();

        if (paths.length > 0) {
            output.append(String.format("<a href=\"%s\">%s</a>", locations.toString(), "HOME"));
        } else {
            output.append(String.format("<span class=\"active\">%s</span>", "HOME"));
        }

        for (int i = 0; i < paths.length - 1; i++) {
            locations.append(paths[i]).append("/");
            output.append(separator)
                    .append(String.format("<a href=\"%s\">%s</a>", locations.toString(), getBcString(paths[i])));
        }

        if (paths.length > 0) {
            output.append(separator)
                    .append(String.format("<span class=\"active\">%s</span>", getBcString(paths[paths.length - 1])));
        }
        System.out.println(output.toString());
        return output.toString();
    }

    public static String getBcString(String path) {
        String bcString = "";
        if (path.length() > 30) {
            bcString = Arrays.stream(path.split("-"))
                    .filter(item -> !item.matches("the|of|in|from|by|with|and|or|for|to|at|a"))
                    .map(item -> item.substring(0, 1).toUpperCase()).collect(Collectors.joining(""));
        } else {
            bcString = path.toUpperCase().replaceAll("-", " ");
        }

        return bcString;
    }
}
