package com.codewars;

public class SnailSort {

    public static int[] snail(int[][] array) {
        int N = (array == null || array.length == 0 || array[0] == null || array[0].length == 0) ? 0 : array.length;

        int[] result = new int[N * N];

        int[] interval = new int[] { 1, N, -1, -N };
        int turn = 0;
        int val = 0;
        int count = 0;
        int turnAlert = 0;

        while (turn < (N * 2 - 1)) {
            int x = val / N;
            int y = val % N;
            result[count] = array[x][y];

            count++;
            turnAlert++;
            if (turnAlert == N - ((turn + 1) / 2)) {
                turn++;
                turnAlert = 0;
            }
            val += interval[turn % 4];
        }

        return result;
    }

}

class SnailSortBP {

    public static int[] snail(int[][] array) {
        if (array[0].length == 0)
            return new int[0];
        int n = array.length;
        int[] answer = new int[n * n];
        int index = 0;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i; j++) {
                answer[index++] = array[i][j];
                System.out.println(i + "," + j);
            } // 첫번째 루프에서 0번째 1줄을 채움

            for (int j = i + 1; j < n - i; j++) {
                answer[index++] = array[j][n - i - 1];
                System.out.println(j + "," + (n - i - 1));
            } // 두번째 루프에서 1,2 과 2,2 처리
            for (int j = i + 1; j < n - i; j++) {
                answer[index++] = array[n - i - 1][n - j - 1];
                System.out.println((n - i - 1) + "," + (n - j - 1));
            } // 세번째 루프에서는 2,1 2,0 처리
            for (int j = i + 1; j < n - i - 1; j++) {
                answer[index++] = array[n - j - 1][i];
                System.out.println((n - j - 1) + "," + (i));
            } // 마지막 루프에서는 1,0 처리
        }
        if (n % 2 != 0) { // n이 홀수이면 제일 가운데 스퀘어가 남기 때문에 별도 처리
            answer[index++] = array[n / 2][n / 2];
        }
        return answer;
    }
}

/*
 * turn = N*2 - 1 2*2 -> 3turn
 * 
 * 0 1 2 3
 * 
 * 3*3 -> 5turn 4*4 -> 7turn 5*5 -> 9turn. 6*6 -> 11turn.
 * 
 * 0 1 3 2 1 2 -1 1(n - 1) -> N * (n-1) -> -1 (n -1)
 * 
 * 0 1 2 3 4 5 6 7 8
 * 
 * 0 1 2 5 8 7 6 3 4 1 1 3 3 -1 -1 -3 1 2 2 2 1 1 4*4 0 1 2 3 4 5 6 7 8 9 10 11
 * 12 13 14 15
 * 
 * 0 1 2 3 7 11 15 14 13 12 8 4 5 6 10 9 1 1 1 4 4 4 -1 -1 -1 -4 -4 1 1 +4 -1 3
 * 3 3 2 2 1 1 1* (n-1) -> N * (n-1) -> -1 * (n - 1) -> -N ( n - 2) -> 1 ( n -2)
 * -> N (n - 3) - > -1 (n - 3)
 * 
 * 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
 * 
 * 0 1 2 3 4 9 14 19 24 23 22 21 20 15 10 5 6 7 8 13 18 17 16 11 12 1 1 1 1 5 5
 * 5 5 -1 -1 -1 -1 -5 -5 -5 1 1 1 5 5 -1 -1 -5 1 4 4 4 3 3 2 2 1 1 1*(n-1) n*
 * (n-1) -1* (n-1) -n * (n-2) 1* (n-2) n*(n-3) -1* (n-3) -n*(n-4) 1* (n-4) + + -
 * - + + - - +
 * 
 * 0 1 2 3 4 5 11 17 23 29 35 34 33 32 31 30 24 18 12 6 7 8 9 10 16 22 28 27 26
 * 25 19 13 14 15 21 20 1 1 1 1 1 6 6 6 6 6 -1 -1 -1 -1 -1 -6 -6 -6 -6 1 1 1 1 6
 * 6 6 -1 -1 -1 -6 -6 1 5 5 5 4 4 3 3 2 1 1 * (n - 1) n * (n -1) -1 * (n - 1)
 * 
 * 
 * 00 01 02 03 04 10 11 12 13 14
 * 
 * 
 * turn 1 2 3 4 5 6 7 8 9 10 11 += 1(n-1) N(n-1) -1(n-1) -N(n-2) 1(n-2) N(n-3)
 * -1(n-3) -N(n-4) 1(n-4) N(n-5) -1(n-5) 6 5 5 4 4 3 3 2 2 1 1
 */
