package com.codewars;

import java.util.Arrays;

public class WhatsAPerfectPowerAnyway {
    public static int[] isPerfectPower(int n) {
        boolean isPerfect = false;
        int power = 0;
        int count = 0;
        for (int i = (int) Math.sqrt(n); i > 1; i--) {
            for (int m = n; m > 1; m /= i) {

                if (m % i != 0) {
                    isPerfect = false;
                    break;
                }
                count++;
                isPerfect = true;
            }

            if (isPerfect) {
                power = i;
                break;
            }
            count = 0;
        }

        if (power == 0)
            return null;

        System.out.println(Arrays.toString(new int[] { power, count }));
        return new int[] { power, count };
    }
}

class PerfectPowerBP {
    public static int[] isPerfectPower(int n) {
        for (int i = 2;; i++) {
            int root = (int) Math.round(Math.pow(n, 1.0 / i));
            if (root < 2)
                return null;
            if (Math.pow(root, i) == n)
                return new int[] { root, i };
        }
    }
}

class PerfectPowerBP2 {
    public static int[] isPerfectPower(int n) {
        int logOfN = (int) Math.ceil(Math.log(n) / Math.log(2));

        for (int m = 2; m <= n / m; m++) {
            for (int k = 2; k <= logOfN; k++) {
                if (n % m == 0 && Math.pow(m, k) == n) {
                    return new int[] { m, k };
                }
            }
        }
        return null;
    }
}