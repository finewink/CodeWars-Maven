package com.codewars;

import java.util.LinkedList;
import java.util.stream.IntStream;

public class PathFinderShortestPath {

    public static int pathFinder(String maze) {
        int N = maze.indexOf("\n");
        maze = maze.replaceAll("\n", "");

        if (maze.length() == 1)
            return 0;

        //make linkage map
        LinkedList<Integer>[] link = new LinkedList[N * N];
        for (int i = 0; i < N * N; i++) {
            link[i] = new LinkedList<Integer>();
            if (maze.codePointAt(i) == 'W')
                continue;

            if (i - N >= 0 && maze.codePointAt(i - N) != 'W')
                link[i].add(i - N);

            if (i / N == (i - 1) / N && i - 1 >= 0 && maze.codePointAt(i - 1) != 'W')
                link[i].add(i - 1);

            if (i / N == (i + 1) / N && maze.codePointAt(i + 1) != 'W')
                link[i].add(i + 1);

            if (i + N < N * N && maze.codePointAt(i + N) != 'W')
                link[i].add(i + N);
        }

        //distance map initialization
        int[] distances = IntStream.generate(() -> N * N).limit(N * N).toArray();

        getDistance(link, distances, 0, N * N - 1);

        return distances[N * N - 1] == N * N ? -1 : distances[N * N - 1];
    }

    private static void getDistance(LinkedList<Integer>[] link, int[] distances, int start, int dest) {
        LinkedList<int[]> queue = new LinkedList<int[]>();
        int next = start;
        distances[start] = 0;

        while (!link[start].isEmpty()) {
            next = link[start].poll();
            if (distances[start] + 1 < distances[next]) {
                distances[next] = distances[start] + 1;
            }
            queue.add(new int[] { start, next });
        }

        while (!queue.isEmpty()) {
            int[] item = queue.poll();

            while (!link[item[1]].isEmpty()) {
                next = link[item[1]].poll();
                if (distances[item[1]] + 1 < distances[next]) {
                    distances[next] = distances[item[1]] + 1;
                }
                queue.add(new int[] { item[1], next });
            }
        }
    }
}
