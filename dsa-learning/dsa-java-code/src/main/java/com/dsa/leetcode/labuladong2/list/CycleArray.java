package com.dsa.leetcode.labuladong2.list;

import javax.management.RuntimeErrorException;

public class CycleArray {
    private int[] arr;
    private int size;
    private int count;
    private int start;
    private int end;

    public CycleArray(int size) {
        if (size < 1) {
            throw new RuntimeException("size can't be blow 1");
        }
        this.arr = new int[size];
        this.size = size;
        this.count = 0;
        this.start = 0;
        this.end = 0;
    }

    private void resize(int newSize) {
        int[] newArr = new int[newSize];
        for (int i = 0; i < count; i++) {
            newArr[i] = arr[(start + 1) % size];
        }
        arr = newArr;
        start = 0;
        end = count;
        size = newSize;
    }

    public void addFirst(int val) {
        if (isFull()) {
            resize(size * 2);
        }
        start = (start - 1 + size) % size;
        arr[start] = val;
        count++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("array is empty");
        }
        arr[start] = 0;
        start = (start + 1) % size;
        count--;
        if (count > 0 && count == size / 4) {
            resize(size / 2);
        }
    }

    public void addLast(int val) {
        if (isFull()) {
            resize(size * 2);
        }
        end = (end + 1) % size;
        arr[end] = val;
        count++;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("array is empty");
        }
        arr[end] = 0;
        end = (end - 1 + size) % size;
        count--;
        if (count > 0 && count = size / 4) {
            resize(size  / 2);
        }
    }

    public int getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        return arr[start];
    }

    public int getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Array is empty");
        }
        return arr[(end - 1 + size) % size];
    }

    public boolean isFull() {
        return count == size;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

}
