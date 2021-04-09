package com.codewars;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PathFinderCanYouReachTheExitTest {

    @Test
    public void sampleTests() {

        String a = ".W.\n" + ".W.\n" + "...",

                b = ".W.\n" + ".W.\n" + "W..",

                c = "......\n" + "......\n" + "......\n" + "......\n" + "......\n" + "......",

                d = "......\n" + "......\n" + "......\n" + "......\n" + ".....W\n" + "....W.";

        assertEquals(true, PathFinderCanYouReachTheExit.pathFinder(a));
        assertEquals(false, PathFinderCanYouReachTheExit.pathFinder(b));
        assertEquals(true, PathFinderCanYouReachTheExit.pathFinder(c));
        assertEquals(false, PathFinderCanYouReachTheExit.pathFinder(d));
    }

    @Test
    public void test2() {
        assertEquals(true, PathFinderCanYouReachTheExit.pathFinder("."));
    }

    @Test
    public void test3() {
        assertEquals(true, PathFinderCanYouReachTheExit
                .pathFinder("......\n" + "......\n" + "......\n" + "......\n" + "......\n" + "......"));
    }
}
