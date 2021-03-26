package com.codewars;

import java.util.Arrays;

public class Permutation {
    /*
     * 0 1 2 3 0 1 0 2 0 3
     * 
     */
    public static void perm(int[] num, int k, int n) {
        // System.out.printf("%s %d\n", "perm ", k);
        if (k == n) {
            System.out.println(Arrays.toString(num));
            return;
        }
        for (int i = k; i < n; i++) {
            swap(num, k, i);
            perm(num, k + 1, n);
            swap(num, k, i);
            // System.out.println("for eol " + k);
        }
    }

    public static void swap(int[] num, int a, int b) {
        // System.out.printf("%s (%d, %d) %s\n", "swap ", a, b, Arrays.toString(num));
        int tmp = num[a];
        num[a] = num[b];
        num[b] = tmp;
    }

}
