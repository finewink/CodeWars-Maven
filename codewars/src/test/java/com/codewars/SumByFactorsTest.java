package com.codewars;

import static org.junit.Assert.*;
import org.junit.Test;

public class SumByFactorsTest {

    @Test
    public void testOne() {
        int[] lst = new int[] { 12, 15 };
        assertEquals("(2 12)(3 27)(5 15)", SumByFactors.sumOfDivided(lst));
    }

    @Test
    public void test2() {
        int[] lst = new int[] { 15, 21, 24, 30, 45 };
        assertEquals("(2 54)(3 135)(5 90)(7 21)", SumByFactors.sumOfDivided(lst));
    }

    @Test
    public void test3() {
        int[] lst = new int[] { 480, 451, 370, 157, 326, 231, 96, 119, -65, 23, 354, 316, 285, -16, 299, 434, 458, 478,
                86, 6, 216, 148 };
        assertEquals("(2 54)(3 135)(5 90)(7 21)", SumByFactors.sumOfDivided(lst));
    }
}