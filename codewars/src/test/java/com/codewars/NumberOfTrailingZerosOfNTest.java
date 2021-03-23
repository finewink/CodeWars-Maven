package com.codewars;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class NumberOfTrailingZerosOfNTest {
    @Test
    public void testZeros() throws Exception {
        assertThat(NumberOfTrailingZerosOfN.zeros(0), is(0));
        assertThat(NumberOfTrailingZerosOfN.zeros(6), is(1));
        assertThat(NumberOfTrailingZerosOfN.zeros(14), is(2));
        assertThat(NumberOfTrailingZerosOfN.zeros(100), is(24));
    }

    @Test
    public void testZeros2() throws Exception {
        assertThat(NumberOfTrailingZerosOfN.zeros(125), is(31));
    }

    @Test
    public void testZeros3() throws Exception {
        assertThat(NumberOfTrailingZerosOfN.zeros(130), is(32));
    }

    @Test
    public void testZeros4() throws Exception {
        assertThat(NumberOfTrailingZerosOfN.zeros(140), is(34));
    }

    @Test
    public void testZeros5() throws Exception {
        assertThat(NumberOfTrailingZerosOfN.zeros(149), is(35));
    }

    @Test
    public void testZeros6() throws Exception {
        assertThat(NumberOfTrailingZerosOfN.zeros(150), is(37));
    }
}