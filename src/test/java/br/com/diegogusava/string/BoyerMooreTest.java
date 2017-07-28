package br.com.diegogusava.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoyerMooreTest {


    @Test
    public void search() throws Exception {

        final int index = BoyerMoore.search("on", "Contrary to popular belief, Lorem Ipsum is not simply random text.");
        System.out.println(index);
    }

}