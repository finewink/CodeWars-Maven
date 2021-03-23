package com.codewars;

import java.util.Arrays;

public class FindMissingLetter {
    public static char findMissingLetter(char[] array) {
        char end = array[0] < 'z' ? 'z' : 'Z';
        for (char letter = array[0]; letter < end; letter++) {
            if (Arrays.binarySearch(array, letter) < 0) {
                return letter;
            }
        }
        return ' ';
    }

    public static char bp(char[] array) {
        char expectableLetter = array[0];
        for (char letter : array) {
            if (letter != expectableLetter)
                break;
            expectableLetter++;
        }
        return expectableLetter;
    }
}