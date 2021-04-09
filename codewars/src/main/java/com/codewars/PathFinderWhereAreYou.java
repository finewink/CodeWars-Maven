package com.codewars;

import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.regex.Pattern;

// Do your magic...!

public class PathFinderWhereAreYou {
    enum Direction {
        LEFT, UP, RIGHT, DOWN;

        static LinkedList<Direction> directions = new LinkedList<Direction>();
        static {
            directions.addAll(Arrays.asList(Direction.values()));
        }

        public static void move(Point now, int move) {
            Direction peek = directions.peek();
            if (peek == UP) {
                now.setLocation(now.getX(), now.getY() + move);
            } else if (peek == RIGHT) {
                now.setLocation(now.getX() + move, now.getY());
            } else if (peek == DOWN) {
                now.setLocation(now.getX(), now.getY() - move);
            } else if (peek == LEFT) {
                now.setLocation(now.getX() - move, now.getY());
            }
        }

        public static void changeDirection(char flag) {
            if (flag == 'r') {
                directions.addLast(directions.removeFirst());
            } else if (flag == 'R') {
                directions.addLast(directions.removeFirst());
                directions.addLast(directions.removeFirst());
            } else if (flag == 'L') {
                directions.addLast(directions.removeFirst());
                directions.addLast(directions.removeFirst());
            } else {
                directions.addFirst(directions.removeLast());
            }
        }
    }

    static Point now = new Point(0, 0);

    public static Point iAmHere(String path) {
        System.out.println("input:" + path);
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < path.length(); i++) {
            if (Pattern.matches("r|l|R|L", path.charAt(i) + "")) {
                if (sb.length() > 0) {
                    int move = Integer.parseInt(sb.toString());
                    sb.setLength(0);
                    Direction.move(now, move);
                }
                Direction.changeDirection(path.charAt(i));
            } else {
                sb.append(path.charAt(i));
            }
        }

        if (sb.length() > 0) {
            int move = Integer.parseInt(sb.toString());
            sb.setLength(0);
            Direction.move(now, move);
        }

        System.out.println(now.toString());
        return now;
    }
}
