package com.dsa.leetcode.labuladong.array.difference;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @since 2023/12/16 08:40
 */
public class P1094_CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int max = trips[0][2];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, trips[i][2]);
        }

        int[] diff = new int[max + 1];
        for (int i = 0; i < n; i++) {
            int val = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];
            diff[from] += val;
            // tow位置下车
            diff[to] -= val;
        }

        int count = 0;
        for (int i = 0; i <= max; i++) {
            count += diff[i];
            if (count > capacity) {
                return false;
            }
        }
        return true;
    }

    public boolean carPooling2(int[][] trips, int capacity) {
        // 按照to构建小顶堆
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> x[2] - y[2]);
        // 按照from排序
        Arrays.sort(trips, (x, y) -> x[1] - y[1]);

        for (int i = 0; i < trips.length; i++) {
            // 如果heap的顶端trip的to比将要处理的trip的fromxiao
            while (!heap.isEmpty() && heap.peek()[2] <= trips[i][1]) {
                capacity += heap.poll()[0];
            }
            capacity -= trips[i][0];
            heap.offer(trips[i]);
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5}, {3, 5, 7}};
        int capacity = 3;
        P1094_CarPooling p1094 = new P1094_CarPooling();
        System.out.println(p1094.carPooling2(trips, capacity));

    }

}
