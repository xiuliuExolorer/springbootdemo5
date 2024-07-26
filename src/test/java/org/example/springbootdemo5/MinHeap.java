package org.example.springbootdemo5;

// 实现一个最小堆 MinHeap
class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void heapifyUp(int i) {
        int parent = parent(i);
        if (i > 0 && heap[i] < heap[parent]) {
            swap(i, parent);
            heapifyUp(parent);
        }
    }

    private void heapifyDown(int i) {
        int min = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] < heap[min]) {
            min = left;
        }
        if (right < size && heap[right] < heap[min]) {
            min = right;
        }

        if (min != i) {
            swap(i, min);
            heapifyDown(min);
        }
    }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full. Cannot insert more elements.");
            return;
        }

        size++;
        heap[size - 1] = value;
        heapifyUp(size - 1);
    }

    public int extractMin() {
        if (size == 0) {
            System.out.println("Heap is empty.");
            return -1;
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);

        return min;
    }
}