package scs.test;

import org.junit.Test;
import scs.Triangle.Triangle;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class testTri {
    private Triangle tri;
//    @Test
//    public void testTri(){
//        tri = new Triangle();
//        ArrayList<Integer> i = new ArrayList<>(asList(50,20,5,1,1));
//        assertEquals(i,tri.getMoney(77));
//        System.out.println("success 77");
//
//    }

    @Test
    public void testTri1(){
        tri = new Triangle();
        ArrayList<Integer> i = new ArrayList<>();
        assertEquals(i,tri.getMoney(59));
        System.out.println("fail 59");
    }



}
