package com.dsa.leetcode.pingan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SensorCoverage {

    public static int findMaxCoverage2(int[][] sensors) {
        int n = sensors.length;
        int[] begins = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            int[] sensor = sensors[i];
            begins[i] = sensor[0] - sensor[1];
            ends[i] = sensor[0] + sensor[1];
        }
        Arrays.sort(begins);
        Arrays.sort(ends);

        int count = 0, max = 0, idx = -1, i = 0, j = 0;
        while (i < n && j < n) {
            if (begins[i] <= ends[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            if (count > max) {
                max = count;
                idx = begins[i - 1];
            }
        }
        return idx;
    }



    public static int findMaxCoverage(int[][] sensors) {
        List<int[]> events = new ArrayList<>();
        for (int[] sensor : sensors) {
            int pos = sensor[0];
            int r = sensor[1];
            int start = pos - r;
            int end = pos + r;
            events.add(new int[] { start, 1 }); // 开始覆盖，+1
            events.add(new int[] { end + 1, -1 }); // 结束覆盖，-1
        }

        // 排序事件点：按位置升序，位置相同则先处理-1（结束）
        events.sort((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        int maxCoverage = 0;
        int currentCoverage = 0;
        int resultPos = Integer.MAX_VALUE;

        for (int[] event : events) {
            int pos = event[0];
            int delta = event[1];
            currentCoverage += delta;
            if (currentCoverage > maxCoverage) {
                maxCoverage = currentCoverage;
                resultPos = pos;
            } else if (currentCoverage == maxCoverage) {
                if (pos < resultPos) {
                    resultPos = pos;
                }
            }
        }

        return resultPos;
    }

    public static void main(String[] args) {
        int n = 10000;
        int maxLen = 10000;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int length = random.nextInt(1, maxLen);
            int[][] sensors = new int[length][2];
            for (int j = 0; j < length; j++) {
                int[] sensor = new int[] { random.nextInt(1000), random.nextInt(1000) };
                sensors[j] = sensor;
            }
            int res1 = findMaxCoverage(sensors);
            int res2 = findMaxCoverage2(sensors);
            if (res1 != res2) {
                System.out.println(res1 + " = " + res2);
            }
        }
    }
}
