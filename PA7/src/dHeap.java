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

    private static final int TO_DOUBLE = 2; // factor to multiply by to double size
    /**
     * Initializes a binary max heap with capacity = 10
     */
    @SuppressWarnings("unchecked")
    public dHeap() {
        heapSize = DEFAULT_SIZE;
        isMaxHeap = true;
        d = 2;
        heap = (T[]) new Comparable[DEFAULT_SIZE];
    }

    /**
     * Initializes a binary max heap with a given initial capacity.
     *
     * @param heapSize The initial capacity of the heap.
     * @throws IllegalArgumentException if an invalid size is input
     */
    @SuppressWarnings("unchecked")
    public dHeap(int heapSize) {
        if (heapSize <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.heapSize = heapSize;
            isMaxHeap = true;
            d = 2;
            heap = (T[]) new Comparable[heapSize];
        }
    }

    /**
     * Initializes a d-ary heap (with a given value for d), with a given initial
     * capacity.
     *
     * @param d         The number of child nodes each node in the heap should have.
     * @param heapSize  The initial capacity of the heap.
     * @param isMaxHeap indicates whether the heap should be max or min
     * @throws IllegalArgumentException if d is less than one or an invalid size is input.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int d, int heapSize, boolean isMaxHeap) throws IllegalArgumentException {
        if (d < 1 || heapSize <= 0) {
            throw new IllegalArgumentException();
        }

        this.d = d;
        this.isMaxHeap = isMaxHeap;
        this.heapSize = heapSize;
        heap = (T[]) new Comparable[heapSize];
    }

    /**
     * returns the size of the heap
     * @return int
     */
    @Override
    public int size() {
        return nelems;
    }

    /**
     * removes and returns the root element of the heap and reorganizes it
     *
     * @return element that was at the root of the heap
     * @throws NoSuchElementException when the heap is empty
     */
    @Override
    public T remove() throws NoSuchElementException {
        if (nelems == 0) {
            throw new NoSuchElementException();
        } else {
            T output = heap[0];
            nelems--;
            heap[0] = heap[nelems];

            trickleDown(0);

            return output;
        }
    }

    /**
     * adds an element to the heap and modifies it so it is still a max/min heap
     *
     * @param item The element to add.
     * @throws NullPointerException if the element added is null
     */
    @Override
    public void add(T item) throws NullPointerException {
        if (item == null) {
            throw new NullPointerException();
        } else {
            if (nelems == heapSize) {
                this.resize();
            }
            nelems++;
            heap[nelems - 1] = item;
            bubbleUp(nelems - 1);
        }
    }

    /**
     * removes all elements from the heap
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        heap = (T[]) new Comparable[heapSize];
        nelems = 0;
    }

    /**
     * reterns the first element of the heap
     *
     * @return element at the root of the heap
     * @throws NoSuchElementException when the heap is empty
     */
    @Override
    public T element() throws NoSuchElementException {
        if (nelems == 0) {
            throw new NoSuchElementException();
        } else {
            return heap[0];
        }
    }

    /**
     * returns the index of the parent
     *
     * @param index index whose parents you want to find
     * @return int
     */
    private int parent(int index) {
        return (index - 1) / d;
    }

    /**
     * returns all the children of an input index in an array
     *
     * @param index index whose children you want to find
     * @return int array
     */
    private int[] children(int index) {
        int[] children = new int[d];

        for (int i = 0; i < d; i++) {
            int child = index * d + 1 + i;
            children[i] = child;
        }
        return children;
    }

    /**
     * compares value at an index with its parent and swaps them if needed
     *
     * @param index index to bubble up
     */
    private void bubbleUp(int index) {
        int parent = this.parent(index);
        T temp;

        if (index == 0) {
            return;
        }

        if (isMaxHeap) {
            if (heap[index].compareTo(heap[parent]) <= 0) {
                return;
            } else {
                temp = heap[index];
                heap[index] = heap[parent];
                heap[parent] = temp;

                bubbleUp(parent);
            }
        } else {
            if (heap[index].compareTo(heap[parent]) >= 0) {
                return;
            } else {
                temp = heap[index];
                heap[index] = heap[parent];
                heap[parent] = temp;

                bubbleUp(parent);
            }
        }
    }

    /**
     * compares value at an index with its children and makes a swap if necessary
     *
     * @param index index to trickle down
     */
    private void trickleDown(int index) {
        int[] childrenIndexes = this.children(index);

        int indexToSwap = childrenIndexes[0];

        if (indexToSwap >= nelems) {
            return;
        }

        T valueToSwap = heap[childrenIndexes[0]];

        if (isMaxHeap) {
            for (int i = 1; i < d; i++) {
                int currIndex = childrenIndexes[i];
                T currValue = heap[currIndex];

                if (currIndex < nelems && currValue.compareTo(valueToSwap) > 0) {
                    indexToSwap = currIndex;
                    valueToSwap = currValue;
                }
            }
            if (heap[index].compareTo(valueToSwap) >= 0) {
                return;
            } else {
                T temp = heap[index];
                heap[index] = heap[indexToSwap];
                heap[indexToSwap] = temp;

                trickleDown(indexToSwap);
            }
        } else if (!isMaxHeap) {
            for (int i = 1; i < d; i++) {
                int currIndex = childrenIndexes[i];
                T currValue = heap[currIndex];

                if (currIndex < nelems && currValue.compareTo(valueToSwap) < 0) {
                    indexToSwap = currIndex;
                    valueToSwap = currValue;
                }
            }
            if (heap[index].compareTo(valueToSwap) <= 0) {
                return;
            } else {
                T temp = heap[index];
                heap[index] = heap[indexToSwap];
                heap[indexToSwap] = temp;

                trickleDown(indexToSwap);
            }
        }
    }

    /**
     * doubles the size of the heap when max capacity is reached
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        heapSize = heapSize * TO_DOUBLE;
        T[] temp = (T[]) new Comparable[heapSize];

        for (int i = 0; i < heap.length; i++) {
            temp[i] = heap[i];
        }

        heap = temp;
    }
}
