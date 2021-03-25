package com.codewars;

/**
 * An isogram is a word that has no repeating letters, consecutive or
 * non-consecutive. Implement a function that determines whether a string that
 * contains only letters is an isogram. Assume the empty string is an isogram.
 * Ignore letter case.
 * 
 * isIsogram "Dermatoglyphics" == true isIsogram "aba" == false isIsogram
 * "moOse" == false -- ignore letter case
 */
public class isogram {
    public static boolean isIsogram(String str) {
        // ...
        for (int i = 0; i < str.length(); i++)
            if (new StringBuilder(str.toLowerCase()).deleteCharAt(i)
                    .indexOf(String.valueOf(str.toLowerCase().charAt(i))) > -1)
                return false;
        return true;
    }

    public static boolean bp(String str) {
        return str.length() == str.toLowerCase().chars().distinct().count();
    }
}
