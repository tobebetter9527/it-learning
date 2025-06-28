package com.dsa.leetcode.labuladong2.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class P752_OpenTheLock {
    char[][] mappping = { { '1', '9' }, { '0', '2' }, { '1', '3' }, { '2', '4' }, { '3', '5' }, { '4', '6' },
            { '5', '7' }, { '6', '8' }, { '7', '9' }, { '8', '0' } };

    public int openLock(String[] deadends, String target) {
        Set<String> deadLocks = new HashSet<>();
        for (String deadend : deadends) {
            deadLocks.add(deadend);
        }

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer("0000");
        visited.add("0000");
        int step = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(target)) {
                    return step;
                }
                if (deadLocks.contains(cur)) {
                    continue;
                }
                for (String string : getNeighbors(cur)) {
                    if (!visited.contains(string)) {
                        q.offer(string);
                        visited.add(string);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private List<String> getNeighbors(String cur) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char c = cur.charAt(i);
            for (char r : mappping[Integer.parseInt(c + "")]) {
                list.add(getNewLock(cur, i, r));
            }
        }
        return list;
    }

    private String getNewLock(String cur, int i, char r) {
        char[] chars = cur.toCharArray();
        chars[i] = r;
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
        String target = "0202";
        P752_OpenTheLock p = new P752_OpenTheLock();
        int step = p.openLock(deadends, target);
        System.out.println(step);

    }

}
