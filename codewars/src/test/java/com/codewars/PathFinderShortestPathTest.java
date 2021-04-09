package com.codewars;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PathFinderShortestPathTest {

    @Test
    public void sampleTests() {

        String a = ".W.\n" + ".W.\n" + "...",

                b = ".W.\n" + ".W.\n" + "W..",

                c = "......\n" + "......\n" + "......\n" + "......\n" + "......\n" + "......",

                d = "......\n" + "......\n" + "......\n" + "......\n" + ".....W\n" + "....W.";

        assertEquals(a, 4, PathFinderShortestPath.pathFinder(a));
        assertEquals(b, -1, PathFinderShortestPath.pathFinder(b));
        assertEquals(c, 10, PathFinderShortestPath.pathFinder(c));
        assertEquals(d, -1, PathFinderShortestPath.pathFinder(d));
    }

    @Test
    public void sampleTests2() {

        String a = ".W.\n" + ".W.\n" + "...",

                b = ".W.\n" + ".W.\n" + "W..",

                c = "......\n" + "......\n" + "......\n" + "......\n" + "......\n" + "......",

                d = "......\n" + "......\n" + "......\n" + "......\n" + ".....W\n" + "....W.";

        assertEquals(a, 4, PathFinderShortestPath.pathFinder(a));
        //assertEquals(b, -1, PathFinderShortestPath.pathFinder(b));
        //assertEquals(c, 10, PathFinderShortestPath.pathFinder(c));
        //assertEquals(d, -1, PathFinderShortestPath.pathFinder(d));
    }
}
