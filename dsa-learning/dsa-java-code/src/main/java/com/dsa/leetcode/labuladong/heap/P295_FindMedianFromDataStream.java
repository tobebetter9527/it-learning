package com.dsa.leetcode.labuladong.heap;

import java.util.PriorityQueue;

public class P295_FindMedianFromDataStream {
    class MedianFinder {
        PriorityQueue<Integer> min;
        PriorityQueue<Integer> max;

        public MedianFinder() {
            min = new PriorityQueue<>();
            max = new PriorityQueue<>(11, (a, b) -> b.compareTo(a));
        }

        //        public void addNum(int num) {
//            if (min.size() > max.size()) {
//                min.add(num);
//                max.add(min.poll());
//            } else {
//                max.add(num);
//                min.add(max.poll());
//            }
//        }
        public void addNum(int num) {
            if (min.isEmpty() || num >= min.peek()) {
                min.add(num);
                if (min.size() > max.size() + 1) {
                    max.add(min.poll());
                }
            } else {
                max.add(num);
                if (max.size() > min.size()) {
                    min.add(max.poll());
                }
            }
        }

        public double findMedian() {
            if (min.size() > max.size()) {
                return min.peek();
            } else {
                return (min.peek() + max.peek()) / 2.0D;
            }
        }
    }
}
