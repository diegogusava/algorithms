package br.com.diegogusava.datastructures.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackArrayTest {

    private StackArray stack;

    @Before
    public void setUp() {
        stack = new StackArray();
    }

    @Test
    public void push() {
        stack.push(1);
        Assert.assertEquals(new Integer(1), stack.pop());
        Assert.assertEquals(0, stack.getSize());
    }

    @Test
    public void popEmptyStack() {
        Integer result = stack.pop();
        Assert.assertEquals(null, result);
    }

    @Test
    public void popOneItem() {
        stack.push(1);
        Assert.assertEquals(new Integer(1), stack.peek());
        Assert.assertEquals(1, stack.getSize());

        Integer result = stack.pop();
        Assert.assertEquals(new Integer(1), result);
    }

    @Test
    public void popTwoItemWithStackWithOneItem() {
        stack.push(1);
        Assert.assertEquals(new Integer(1), stack.pop());
        Assert.assertEquals(0, stack.getSize());

        stack.pop();
        Integer result = stack.pop();
        Assert.assertEquals(null, result);
    }

    @Test
    public void resize() {

        for (int i = 0; i < 30; i++) {
            stack.push(i);
        }

        Assert.assertEquals(30, stack.getSize());
    }
}