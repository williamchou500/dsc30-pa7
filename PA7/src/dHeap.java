/*
 * Name: William Chou
 * PID:  A17830823
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Title: dHeap Description: This program creates a Heap with d branching factor
 *
 * @author William Chou
 * @since 2024-5-21
 *
 * @param <T> the type of elements held in this collection
 */

public class dHeap<T extends Comparable<? super T>> implements HeapInterface<T> {

    private T[] heap;   // backing array
    private int d;      // branching factor
    private int nelems; // number of elements
    private boolean isMaxHeap; // indicates whether heap is max or

    private int heapSize; // size of heap

    private static final int DEFAULT_SIZE = 10; // default size for constructor

    /**
     * Initializes a binary max heap with capacity = 10
     */
    @SuppressWarnings("unchecked")
    public dHeap() {
        heapSize = DEFAULT_SIZE;
        heap = (T[]) new Comparable[DEFAULT_SIZE];
    }

    /**
     * Initializes a binary max heap with a given initial capacity.
     *
     * @param heapSize The initial capacity of the heap.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int heapSize) {
        this.heapSize = heapSize;
        heap = (T[]) new Comparable[heapSize];
    }

    /**
     * Initializes a d-ary heap (with a given value for d), with a given initial
     * capacity.
     *
     * @param d         The number of child nodes each node in the heap should have.
     * @param heapSize  The initial capacity of the heap.
     * @param isMaxHeap indicates whether the heap should be max or min
     * @throws IllegalArgumentException if d is less than one.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int d, int heapSize, boolean isMaxHeap) throws IllegalArgumentException {
        this.d = d;
        this.isMaxHeap = isMaxHeap;
        this.heapSize = heapSize;
        heap = (T[]) new Comparable[heapSize];
    }

    @Override
    public int size() {
        return nelems;
    }

    @Override
    public T remove() throws NoSuchElementException {
        if (this.size() == 0) {
            throw new NoSuchElementException();
        } else {
            return null;
        }
    }

    @Override
    public void add(T item) throws NullPointerException {
        if (item == null) {
            throw new NullPointerException();
        } else {
            return;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        heap = (T[]) new Comparable[heapSize];
    }

    @Override
    public T element() throws NoSuchElementException {
        if (this.size() == 0) {
            throw new NoSuchElementException();
        } else {
            return null;
        }
    }

    private int parent(int index) {
        // TODO
        return 0;
    }

    private void bubbleUp(int index) {
        // TODO
    }

    private void trickleDown(int index) {
        // TODO
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        // TODO
    }

}
