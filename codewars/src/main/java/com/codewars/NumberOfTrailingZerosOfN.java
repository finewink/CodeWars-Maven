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
        int div = getDiv5(n, 0);
        return n == 0 ? 0 : (n / 5) + div;
    }

    public static int getDiv5(int num, int time) {
        int last = num / 5;
        if (last > 5) {
            num = getDiv5(num, time + 1);
        }

        return num;
    }
}

// 150 / 5 = 30
// 150 / 25 = 6
// 20 4
// 25 6
// 30 7
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
// 99 00 00000 00000 00000 00000 22
// 100 0000 00000 00000 00000 00000 24
// 124 0000000000000000000000000000 28
// 125 0 00000 00000 00000 00000 00000 00000 31
// 149 00000 00000 00000 00000 00000 00000 00000 35
// 150 00 00000 00000 00000 00000 00000 00000 00000 37
