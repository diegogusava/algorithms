package br.com.diegogusava.datastructures.heap;

public class MaxPriorityQueue implements Heap {

    private int current;
    private Integer[] queue;

    public MaxPriorityQueue(int size) {
        this.current = -1;
        this.queue = new Integer[size];
    }

    @Override
    public void insert(int value) {
        queue[++current] = value;
        shiftUp(current);
    }

    public int extract() {
        if (current < 0) {
            throw new IllegalStateException();
        }
        Integer max = queue[0];
        Integer last = queue[current];
        queue[current--] = null;
        queue[0] = last;
        shiftDown(0);
        return max;
    }


    public void shiftDown(int index) {

        int maxIndex = index;

        do {
            int leftIndex = getLeftIndex(index);

            if (leftIndex <= current && queue[leftIndex] > queue[maxIndex]) {
                maxIndex = leftIndex;
            }

            int rightIndex = getRightIndex(index);

            if (rightIndex <= current && queue[rightIndex] > queue[maxIndex]) {
                maxIndex = rightIndex;
            }

            if (maxIndex != index) {

                Integer temp = queue[index];
                queue[index] = queue[maxIndex];
                queue[maxIndex] = temp;
                index = maxIndex;

            }
        } while (maxIndex != index);

    }

    private int getLeftIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightIndex(int index) {
        return 2 * index + 2;
    }

    private void shiftUp(int index) {
        if (current == 0) {
            return;
        }

        int parent = getParent(index);

        while (queue[index] > queue[parent]) {
            int temp = queue[index];
            queue[index] = queue[parent];
            queue[parent] = temp;

            index = parent;
            parent = getParent(index);
        }
    }

    private int getParent(int index) {
        int parent = (index - 1) / 2;
        parent = parent >= 0 ? parent : 0;
        return parent;
    }


    public int getSize() {
        return current + 1;
    }
}
