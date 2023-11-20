package com.dsa.leetcode.labuladong.bfs;

import java.util.*;

public class P752_OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains(target) || visited.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        // 从0000开始搜索
        queue.add("0000");
        int minStep = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String lockStatus = queue.poll();
                if (target.equals(lockStatus)) {
                    return minStep;
                }
                String[] strings = getNeighbors(lockStatus);
                for (String neighbor : strings) {
                    if (visited.add(neighbor)) {
                        queue.add(neighbor);
                    }
                }
            }
            minStep++;
        }
        return -1;
    }

    private String[] getNeighbors(String lockStatus) {
        String[] neighbors = new String[8];
        int index = 0;

        char[] chars = lockStatus.toCharArray();
        for (int i = 0; i < 4; i++) {
            char temp = chars[i];
            chars[i] = addOne(temp);
            neighbors[index++] = String.valueOf(chars);
            chars[i] = minusOne(temp);
            neighbors[index++] = String.valueOf(chars);
            chars[i] = temp;
        }
        return neighbors;
    }

    private char minusOne(char temp) {
        return temp == '0' ? '9' : (char) (temp - 1);
    }

    private char addOne(char temp) {
        return temp == '9' ? '0' : (char) (temp + 1);
    }

    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        P752_OpenTheLock p752OpenTheLock = new P752_OpenTheLock();
        System.out.println(p752OpenTheLock.openLock(deadends, target));
    }
}
