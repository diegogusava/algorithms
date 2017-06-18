package br.com.diegogusava.datastructures.stack;

public class StackArray {

    private Integer[] stack;
    private int size;

    public StackArray() {
        this(8);
    }

    public StackArray(Integer size) {
        stack = new Integer[size];
    }

    /**
     * O(1) se não tiver resize
     *
     * @return
     */
    public void push(Integer value) {

        if (size == stack.length) {
            resize(2 * stack.length);
        }

        stack[size++] = value;
    }

    /**
     * O(1) se não tiver resize
     *
     * @return
     */
    public Integer pop() {

        if (size == 0) {
            return null;
        }

        if (size == stack.length / 4) {
            resize(stack.length / 2);
        }

        int value = stack[--size];
        stack[size] = null;

        return value;
    }

    /**
     * O(1)
     *
     * @return
     */
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return stack[size - 1];
    }

    /**
     * O(n)
     *
     * @param size
     */
    private void resize(int size) {
        Integer[] copy = new Integer[size];

        for (int i = 0; i < stack.length; i++) {
            copy[i] = stack[i];
        }

        this.stack = copy;
    }


    public int getSize() {
        return size;
    }
}
