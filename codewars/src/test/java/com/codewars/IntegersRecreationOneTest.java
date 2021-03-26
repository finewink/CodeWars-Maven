package com.codewars;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegersRecreationOneTest {

    @Test
    public void test1() {
        assertEquals("[[1, 1], [42, 2500], [246, 84100]]", IntegersRecreationOne.listSquared(1, 250));
    }

    @Test
    public void test2() {
        assertEquals("[[42, 2500], [246, 84100]]", IntegersRecreationOne.listSquared(42, 250));
    }

    @Test
    public void test3() {
        assertEquals("[[287, 84100]]", IntegersRecreationOne.listSquared(250, 500));
    }

}
