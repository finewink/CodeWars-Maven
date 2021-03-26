package com.codewars;

import java.util.Arrays;

public class PermutationN {
    /***
     * 
     * @param numbers 순열을 추출할 숫자 배열
     * @param n       순열의 길이
     * @param k       고정열을 지칭하기 위한 지시자
     * @param l       입력배열의 길이
     */
    public static void perm(int[] numbers, int[] output, int n, int k, int l) {
        if (k == l) {
            System.out.println(Arrays.toString(output));
            return;
        }

        for (int i = k; i < l; i++) {
            swap(numbers, k, i);
            output[k] = numbers[i];
            perm(numbers, output, n, k + 1, l);
            swap(numbers, k, i);
        }
    }

    public static void swap(int[] num, int a, int b) {
        // System.out.printf("%s (%d, %d) %s\n", "swap ", a, b, Arrays.toString(num));
        int tmp = num[a];
        num[a] = num[b];
        num[b] = tmp;
    }

}
