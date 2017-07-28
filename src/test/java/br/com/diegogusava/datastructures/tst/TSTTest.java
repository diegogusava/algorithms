package br.com.diegogusava.datastructures.tst;

import org.junit.Test;

import static org.junit.Assert.*;

public class TSTTest {
    @Test
    public void put() {

        final TST tst = new TST();
        tst.put("cat", 1);
        tst.put("apple", 2);
        tst.put("car", 3);
        tst.put("carrot", 4);
        tst.put("cow", 5);

        System.out.println(tst.find("cat"));
        System.out.println(tst.find("apple"));
        System.out.println(tst.find("car"));
        System.out.println(tst.find("carrot"));
        System.out.println(tst.find("cow"));
    }

}