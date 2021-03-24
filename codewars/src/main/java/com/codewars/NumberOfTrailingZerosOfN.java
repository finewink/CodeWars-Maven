package com.codewars;

/**
 * Write a program that will calculate the number of trailing zeros in a
 * factorial of a given number.
 * 
 * N! = 1 * 2 * 3 * ... * N
 * 
 * Be careful 1000! has 2568 digits...
 * 
 * For more info, see: http://mathworld.wolfram.com/Factorial.html
 * 
 * Examples zeros(6) = 1 # 6! = 1 * 2 * 3 * 4 * 5 * 6 = 720 --> 1 trailing zero
 * 
 * zeros(12) = 2 # 12! = 479001600 --> 2 trailing zeros Hint: You're not meant
 * to calculate the factorial. Find another way to find the number of zeros.
 */
public class NumberOfTrailingZerosOfN {
    public static int zeros(int n) {
        int div = getDiv5(n, 5, 0);
        return n == 0 ? 0 : div;
    }

    public static int getDiv5(int num, int div, int count) {
        int last = num / div;
        if (last >= 0 & div <= num) {
            count = getDiv5(num, div * 5, count + last);
        }
        return count;
    }

    public static int bp(int n) {
        int res = 0;
        for (int i = 5; i <= n; i *= 5) {
            res += n / i;
        }
        return res;
    }

    public static int bp2(int n) {
        if (n / 5 == 0)
            return 0;
        return n / 5 + zeros(n / 5);
    }
}

// 150 / 5 = 30
// 150 / 25 = 6
// 20 4
// 25 6 // 5 + 1

// 30 7 6 + 1
// 35 8
// 40 9
// 45 10
// 50 00 00000 00000 12
// 51 00 00000 00000 12
// 55 000 00000 00000 13
// 60 0000 00000 00000 14
// 65 00000 00000 00000 15
// 70 0 00000 00000 00000 16
// 75 000 00000 00000 00000 18
// 99 00 00000 00000 00000 00000 22 19 +
// 100 0000 00000 00000 00000 00000 24
// 124 0000000000000000000000000000 28

// 125 0 00000 00000 00000 00000 00000 00000 31 3
// 149 00000 00000 00000 00000 00000 00000 00000 35
// 150 00 00000 00000 00000 00000 00000 00000 00000 37
// 249 59
// 250 62
// 499 121
// 500 125
// 624 152
// 625 156 4
// 999 246
// 1000 249 4

// 200 + 1000/25=40 + 9(5로 4번 나누기 가능, 25로 2번 125로 1번 625로 1번)

// 199 + 39 + 7 + (245) + 1
// 100 + 20 + 20/5 = 4 + 1
// 200 + 40 + 40 /5 + 1
// 15625
