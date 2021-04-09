package com.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * PathFinderTheAlphinist
 */
public class PathFinderTheAlphinist {

    public static int pathFinder(String maze) {
        int N = maze.indexOf("\n");
        maze = maze.replaceAll("\n", "");

        if (maze.length() == 1)
            return 0;

        //make linkage map
        LinkedList<int[]>[] link = new LinkedList[N * N];
        for (int i = 0; i < N * N; i++) {
            link[i] = new LinkedList<int[]>();
            if (i - N >= 0)
                link[i].add(new int[] { i - N, Math.abs(maze.codePointAt(i - N) - maze.codePointAt(i)) });

            if (i / N == (i - 1) / N && i - 1 >= 0)
                link[i].add(new int[] { i - 1, Math.abs(maze.codePointAt(i - 1) - maze.codePointAt(i)) });

            if (i / N == (i + 1) / N)
                link[i].add(new int[] { i + 1, Math.abs(maze.codePointAt(i + 1) - maze.codePointAt(i)) });

            if (i + N < N * N)
                link[i].add(new int[] { i + N, Math.abs(maze.codePointAt(i + N) - maze.codePointAt(i)) });
        }

        //distance map initialization
        int[] distances = IntStream.generate(() -> N * N * 9).limit(N * N).toArray();

        getDistance(link, distances, 0, N * N - 1);

        return distances[N * N - 1] == N * N * 9 ? -1 : distances[N * N - 1];
    }

    private static void getDistance(LinkedList<int[]>[] link, int[] distances, int start, int dest) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            };
        });
        queue.add(new int[] { start, start, 0 });
        distances[start] = 0;

        while (!queue.isEmpty()) {
            int[] item = queue.poll();

            //avoid rewrite to longer path
            if (distances[item[0]] + item[2] > distances[item[1]]) {
                continue;
            }
            for (int[] v : link[item[1]]) {

                if (distances[item[1]] + v[1] < distances[v[0]]) {
                    distances[v[0]] = distances[item[1]] + v[1];

                    queue.add(new int[] { item[1], v[0], v[1] });
                }
            }
        }
    }

    public static int pathFinder2(String maze) {
        System.out.println(maze + "\n");
        int N = maze.indexOf("\n");
        maze = maze.replaceAll("\n", "");

        if (maze.length() == 1)
            return 0;

        //make linkage map
        LinkedList<int[]>[] link = new LinkedList[N * N];
        //ArrayList<int[]> link = new ArrayList<int[]>();
        for (int i = 0; i < N * N; i++) {
            link[i] = new LinkedList<int[]>();
            // link[i] = new PriorityQueue<int[]>(new Comparator<int[]>() {
            //     @Override
            //     public int compare(int[] o1, int[] o2) {
            //         return Integer.compare(o1[1], o2[1]);
            //     }
            // });
            if (i - N >= 0)
                link[i].add(new int[] { i - N, Math.abs(maze.codePointAt(i - N) - maze.codePointAt(i)) });

            if (i / N == (i - 1) / N && i - 1 >= 0)
                link[i].add(new int[] { i - 1, Math.abs(maze.codePointAt(i - 1) - maze.codePointAt(i)) });

            if (i / N == (i + 1) / N)
                link[i].add(new int[] { i + 1, Math.abs(maze.codePointAt(i + 1) - maze.codePointAt(i)) });

            if (i + N < N * N)
                link[i].add(new int[] { i + N, Math.abs(maze.codePointAt(i + N) - maze.codePointAt(i)) });
        }

        //distance map initialization
        int[] distances = IntStream.generate(() -> N * N * 9).limit(N * N).toArray();

        getDistance2(link, distances, 0, N * N - 1);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < distances.length; i++) {

            if (i % Math.sqrt(link.length) == 0) {
                sb.append("\n");
            }
            sb.append(String.format("%4d\t ", distances[i]));
        }
        System.out.println(sb.toString());

        return distances[N * N - 1] == N * N * 9 ? -1 : distances[N * N - 1];
    }

    private static void getDistance2(LinkedList<int[]>[] link, int[] distances, int start, int dest) {
        LinkedList<int[]> queue = new LinkedList<int[]>();
        //int[] next = null;
        distances[start] = 0;
        boolean visit[] = new boolean[link.length];
        //visit[0] = true;

        queue.add(new int[] { start, start });
        // while (!link[start].isEmpty()) {
        //     next = link[start].poll();
        //     distances[next[0]] = distances[start] + next[1];

        // }

        while (!queue.isEmpty()) {
            int[] item = queue.poll();

            if (!visit[item[1]]) {
                for (int[] v : link[item[1]]) {
                    //while (!link[item[1]].isEmpty()) {
                    //next = link[item[1]].poll();

                    if (distances[item[1]] + v[1] < distances[v[0]]) {
                        distances[v[0]] = distances[item[1]] + v[1];
                        // System.out.println(String.format("[(%d, %d) %d]", item[1], next[0], next[1]));
                        // StringBuffer sb = new StringBuffer();
                        // for (int i = 0; i < distances.length; i++) {

                        //     if (i % Math.sqrt(link.length) == 0) {
                        //         sb.append("\n");
                        //     }
                        //     sb.append(String.format("%4d ", distances[i]));
                        // }
                        // System.out.println(sb.toString());
                        queue.add(new int[] { item[1], v[0] });
                    }
                }
            }
            visit[item[1]] = true;
        }
    }
}

class Finder {

    public static int pathFinder(String maze) {
        //System.out.println(maze + "\n");
        int N = maze.indexOf("\n");
        maze = maze.replaceAll("\n", "");

        if (maze.length() == 1)
            return 0;

        //make linkage map
        LinkedList<int[]>[] link = new LinkedList[N * N];
        //ArrayList<int[]> link = new ArrayList<int[]>();
        for (int i = 0; i < N * N; i++) {
            link[i] = new LinkedList<int[]>();
            // link[i] = new PriorityQueue<int[]>(new Comparator<int[]>() {
            //     @Override
            //     public int compare(int[] o1, int[] o2) {
            //         return Integer.compare(o1[1], o2[1]);
            //     }
            // });
            if (i - N >= 0)
                link[i].add(new int[] { i - N, Math.abs(maze.codePointAt(i - N) - maze.codePointAt(i)) });

            if (i / N == (i - 1) / N && i - 1 >= 0)
                link[i].add(new int[] { i - 1, Math.abs(maze.codePointAt(i - 1) - maze.codePointAt(i)) });

            if (i / N == (i + 1) / N)
                link[i].add(new int[] { i + 1, Math.abs(maze.codePointAt(i + 1) - maze.codePointAt(i)) });

            if (i + N < N * N)
                link[i].add(new int[] { i + N, Math.abs(maze.codePointAt(i + N) - maze.codePointAt(i)) });
        }

        //distance map initialization
        int[] distances = IntStream.generate(() -> N * N * 9).limit(N * N).toArray();

        getDistance(link, distances, 0, N * N - 1);

        //StringBuffer sb = new StringBuffer();
        //for (int i = 0; i < distances.length; i++) {
        //
        //    if (i % Math.sqrt(link.length) == 0) {
        //        sb.append("\n");
        //    }
        //    sb.append(String.format("%4d\t ", distances[i]));
        //}
        //System.out.println(sb.toString());

        return distances[N * N - 1] == N * N * 9 ? -1 : distances[N * N - 1];
    }

    private static void getDistance(LinkedList<int[]>[] link, int[] distances, int start, int dest) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            };
        });

        distances[start] = 0;

        queue.add(new int[] { start, start, 0 });

        while (!queue.isEmpty()) {
            int[] item = queue.poll();
            //System.out.printf("poll (%d, %d, %d)\n", item[0], item[1], item[2]);

            if (distances[item[0]] + item[2] > distances[item[1]]) {
                //System.out.printf("pass loop : distances[%d] + %d (%d) > distances[%d] (%d)\n", item[0], item[2],
                //        distances[item[0]] + item[2], item[1], distances[item[1]]);
                continue;
            }
            for (int[] v : link[item[1]]) {

                if (distances[item[1]] + v[1] < distances[v[0]]) {

                    //System.out.println(String.format("\t%d ->(%d)-> %d, dist[%d]= %d -> %d", item[1], v[1], v[0], v[0],
                    //        distances[v[0]], distances[item[1]] + v[1]));
                    distances[v[0]] = distances[item[1]] + v[1];

                    queue.add(new int[] { item[1], v[0], v[1] });
                    //System.out.printf("\t\tqueue.add(%d, %d, %d)\n", item[1], v[0], v[1]);
                } else {
                    //System.out.println(String.format(
                    //        "\tpass by distance :  %d ->(%d)-> %d, dist[%d] + %d (%d) > dist[%d] (%d)", item[1], v[1],
                    //       v[0], item[1], v[1], distances[item[1]] + v[1], v[0], distances[v[0]]));
                }
            }
        }

    }
}