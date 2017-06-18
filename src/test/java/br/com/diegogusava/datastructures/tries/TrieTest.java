package br.com.diegogusava.datastructures.tries;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {

    private Trie trie;

    @Before
    public void setUp() throws Exception {
        trie = new Trie();
    }

    @Test
    public void insert() throws Exception {
        trie.insert("diego");
    }

    @Test
    public void searchTrue() throws Exception {
        trie.insert("diego");
        boolean result = trie.search("diego");
        assertEquals(true, result);
    }

    @Test
    public void searchTrue2() throws Exception {
        trie.insert("diego");
        boolean result = trie.search("dieg");
        assertEquals(true, result);
    }

    @Test
    public void searchFalse() throws Exception {
        trie.insert("diego");
        boolean result = trie.search("diegoo");
        assertEquals(false, result);
    }


}