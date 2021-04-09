package com.codewars;

import java.util.Arrays;
import java.util.List;

public class ClosestPairOfPointsInLinearithmicTime {
    public static List<Point> closestPair(List<Point> points) {
        MinPoint min = new MinPoint();

        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                min.setPoints(points.get(i), points.get(j));
            }
        }
        return Arrays.asList(min.origin, min.dest);
    }

}

class MinPoint {
    Point origin;
    Point dest;
    double distance;

    public MinPoint() {
        distance = Double.MAX_VALUE;
    }

    public void setPoints(Point a, Point b) {
        double dist = getEuclidianSquare(a, b);
        if (dist < this.distance) {
            this.origin = a;
            this.dest = b;
            this.distance = dist;
        }
    }

    public double getEuclidianSquare(Point a, Point b) {
        return Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2);
    }

}