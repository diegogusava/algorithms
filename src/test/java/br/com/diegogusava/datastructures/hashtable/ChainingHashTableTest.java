package br.com.diegogusava.datastructures.hashtable;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ChainingHashTableTest {

    private ChainingHashTable table;

    @Before
    public void setUp() throws Exception {
        table = new ChainingHashTable(10);
    }

    @Test
    public void put() throws Exception {
        table.put(1, 100);
        table.put(2, 200);
        table.put(3, 300);
        table.put(4, 400);
        table.put(5, 500);

        assertEquals(100, table.get(1).intValue());
        assertEquals(500, table.get(5).intValue());
    }

    @Test
    public void get() throws Exception {

    }

}