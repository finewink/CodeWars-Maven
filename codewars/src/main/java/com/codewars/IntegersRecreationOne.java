package com.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.LongStream;

public class IntegersRecreationOne {
    public static String listSquared(long m, long n) {
        ArrayList<Long[]> listSquare = new ArrayList<Long[]>();
        for (long N = m; N <= n; N++) {
            ArrayList<Long> list = new ArrayList<Long>();
            for (long div = 1; div <= N; div++) {
                if (N % div == 0) {
                    if (!list.contains(div))
                        list.add(div);
                }
            }
            if (!list.isEmpty()) {
                long multi = list.stream().map(item -> item * item).reduce((a, b) -> a + b).get();
                if ((long) Math.sqrt(multi) * (long) Math.sqrt(multi) == multi) {
                    listSquare.add(new Long[] { N, multi });
                }
            }

        }

        return Arrays.deepToString(listSquare.toArray());
    }
}

class SumSquaredDivisorsBP {

    public static String listSquared(long m, long n) {
        // your code
        String result = "[";
        for (long i = m; i <= n; i++) {
            if (Math.round(Math.sqrt(sumOfSquareDivisors(i))) == Math.sqrt(sumOfSquareDivisors(i))) {
                result += "[" + i + ", " + sumOfSquareDivisors(i) + "], ";
            }
        }
        return result.length() > 1 ? result.substring(0, result.length() - 2) + "]" : "[]";
    }

    public static long sumOfSquareDivisors(long n) {
        return LongStream.range(1, n + 1).filter(i -> n % i == 0).map(i -> i * i).sum();
    }
}

class SumSquaredDivisorsBP2 {

    public static String listSquared(long m, long n) {
        ArrayList<String> strings = new ArrayList<>();
        LongStream.rangeClosed(m, n).forEach(current -> {
            long sum = LongStream.rangeClosed(1, current).filter(i -> current % i == 0).map(i -> i * i).sum();
            if (Math.sqrt(sum) % 1 == 0)
                strings.add(String.format("[%d, %d]", current, sum));
        });
        return String.valueOf(strings);
    }
}