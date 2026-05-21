package org.example;

public interface PriorityQueue<E extends Comparable<E>> {

    public void add(E value);

    public E remove();

    public boolean isEmpty();

    public int size();
}