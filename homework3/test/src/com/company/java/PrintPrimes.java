package com.company.java;

import java.util.ArrayList;

// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 7; page ??
// Can be run from command line
// See PrintPrimes.num for a numbered version.
// No JUnit tests at this time

/** *****************************************************
 * Finds and prints n prime integers
 * Jeff Offutt, Spring 2003
 ********************************************************* */
public class PrintPrimes
{

    private static boolean isDivisible (int i, int j)
    {
        if (j%i == 0)
            return true;
        else
            return false;
    }
    public static int[] printPrimes (int n){
        int curPrime;        // Value currently considered for primeness
        int numPrimes;        // Number of primes found so far.
        boolean isPrime;    // Is curPrime prime?
        int [] primes = new int [6]; // The list of prime numbers.
        // Initialize 2 into the list of primes.
        primes[0] = 2;
        numPrimes = 1;
        curPrime = 2;
        while(numPrimes < n){
            curPrime++;        //next number to consider ...
            isPrime = true;
            for(int i = 0; i <= numPrimes-1; i++){
                if(isDivisible(primes[i], curPrime)){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                primes[numPrimes] = curPrime;
                numPrimes++;
            }
        } // end while
        //Print all the primes out.
        for(int i = 0; i <= numPrimes-1; i ++){
            System.out.println("Prime: "+ primes[i]);
        }
        return primes;

    } // end printPrimes
//    public static void main (String []argv)
//    {  // Driver method for printPrimes
//        // Read an integer from standard input, call printPrimes()
//        int integer = 0;
//        if (argv.length != 1)
//        {
//            System.out.println ("Usage: java PrintPrimes v1 ");
//            return;
//        }
//
//        try
//        {
//            integer = Integer.parseInt (argv[0]);
//        }
//        catch (NumberFormatException e)
//        {
//            System.out.println ("Entry must be a integer, using 1.");
//            integer = 1;
//        }
//
//        printPrimes (integer);
//    }
}