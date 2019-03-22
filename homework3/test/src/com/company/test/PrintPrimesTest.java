package com.company.test;


import com.company.java.PrintPrimes;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


public class PrintPrimesTest {
    PrintPrimes p ;
    @Test
    public void testprintPrimes(){
        p = new PrintPrimes();
        int a[] = new int[]{2,3,5,7,11,13};
        assertArrayEquals(a,p.printPrimes(6));
    }

}