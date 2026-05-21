package org.example;

import java.util.ArrayList;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {

    private ArrayList<E> data;

    public VectorHeap() {
        data = new ArrayList<>();
    }

    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    private void percolateUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;

            if (data.get(index).compareTo(data.get(parent)) < 0) {

                E temp = data.get(index);
                data.set(index, data.get(parent));
                data.set(parent, temp);

                index = parent;
            } else {
                break;
            }
        }
    }

    @Override
    public E remove() {

        if (isEmpty()) {
            return null;
        }

        E min = data.get(0);

        E last = data.remove(data.size() - 1);

        if (!data.isEmpty()) {
            data.set(0, last);
            pushDownRoot(0);
        }

        return min;
    }

    private void pushDownRoot(int index) {

        int heapSize = data.size();

        while (true) {

            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < heapSize &&
                    data.get(left).compareTo(data.get(smallest)) < 0) {

                smallest = left;
            }

            if (right < heapSize &&
                    data.get(right).compareTo(data.get(smallest)) < 0) {

                smallest = right;
            }

            if (smallest != index) {

                E temp = data.get(index);
                data.set(index, data.get(smallest));
                data.set(smallest, temp);

                index = smallest;

            } else {
                break;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }
}