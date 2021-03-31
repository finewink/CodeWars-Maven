package com.codewars;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CodewarsStyleRankingSystemTest {

    @Test
    public void testSomething1() {
        CodewarsStyleRankingSystem user = new CodewarsStyleRankingSystem();
        user.incProgress(-7);
        assertEquals(10, user.progress);

    }

    @Test
    public void testSomething2() {
        CodewarsStyleRankingSystem user = new CodewarsStyleRankingSystem();
        user.incProgress(-6);
        assertEquals(40, user.progress);

    }

    @Test
    public void testSomething3() {
        CodewarsStyleRankingSystem user = new CodewarsStyleRankingSystem();
        user.incProgress(-5);
        assertEquals(90, user.progress);

    }

    @Test
    public void testSomething4() {
        CodewarsStyleRankingSystem user = new CodewarsStyleRankingSystem();
        user.incProgress(-4);
        assertEquals(60, user.progress);
        assertEquals(-7, user.rank);

    }

    @Test
    public void testSomething5() {
        CodewarsStyleRankingSystem user = new CodewarsStyleRankingSystem();
        user.rank = -1;
        user.incProgress(1);
        assertEquals(10, user.progress);
    }

    @Test
    public void testSomething6() {
        CodewarsStyleRankingSystem user = new CodewarsStyleRankingSystem();
        assertEquals(-8, user.rank); // => -8
        assertEquals(0, user.progress); // => 0
        user.incProgress(-7);
        assertEquals(10, user.progress); // => 10
        user.incProgress(-5); // will add 90 progress
        assertEquals(0, user.progress); // => 0 // progress is now zero
        assertEquals(-7, user.rank); // => -7 // rank was upgraded to -7

    }

    @Test
    public void testSomething7() {
        CodewarsStyleRankingSystem user = new CodewarsStyleRankingSystem();
        user.incProgress(1);
        System.out.printf("rank:%d, progress:%d\n", user.rank, user.progress);
        user.incProgress(1);
        System.out.printf("rank:%d, progress:%d\n", user.rank, user.progress);
        user.incProgress(1);
        System.out.printf("rank:%d, progress:%d\n", user.rank, user.progress);
        user.incProgress(1);
        System.out.printf("rank:%d, progress:%d\n", user.rank, user.progress);
        user.incProgress(1);
        System.out.printf("rank:%d, progress:%d\n", user.rank, user.progress);
        user.incProgress(1);
        System.out.printf("rank:%d, progress:%d\n", user.rank, user.progress);
        user.incProgress(1);
        System.out.printf("rank:%d, progress:%d\n", user.rank, user.progress);
        user.incProgress(1);
        System.out.printf("rank:%d, progress:%d\n", user.rank, user.progress);
    }

    @Test
    public void testSomething8() {
        CodewarsStyleRankingSystem user = new CodewarsStyleRankingSystem();
        user.incProgress(8);
        System.out.printf("rank:%d, progress:%d\n", user.rank, user.progress);
        user.incProgress(8);
        System.out.printf("rank:%d, progress:%d\n", user.rank, user.progress);
        user.incProgress(8);
        System.out.printf("rank:%d, progress:%d\n", user.rank, user.progress);
        user.incProgress(8);
        System.out.printf("rank:%d, progress:%d\n", user.rank, user.progress);
        user.incProgress(8);
        System.out.printf("rank:%d, progress:%d\n", user.rank, user.progress);
        user.incProgress(8);
        System.out.printf("rank:%d, progress:%d\n", user.rank, user.progress);
        user.incProgress(8);
        System.out.printf("rank:%d, progress:%d\n", user.rank, user.progress);
        user.incProgress(8);
        System.out.printf("rank:%d, progress:%d\n", user.rank, user.progress);
    }
}
