package com.dsa.leetcode.labuladong2.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class P773_SlidingPuzzle {
    int[][] mapping = { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };

    public int slidingPuzzle(int[][] board) {
        int n = board.length, m = board[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(board[i][j]);
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(sb.toString());
        visited.add(sb.toString());
        int step = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals("123450")) {
                    return step;
                }

                for (String node : getNeighbors(cur)) {
                    if (!visited.contains(node)) {
                        q.offer(node);
                        visited.add(node);
                    }
                }
            }
            step++;
        }

        return -1;
    }

    public List<String> getNeighbors(String cur) {
        List<String> list = new ArrayList<>();
        int index = cur.indexOf("0");
        for (int idx : mapping[index]) {
            list.add(swap(cur.toCharArray(), idx, index));
        }
        return list;
    }

    private String swap(char[] charArray, int idx, int index) {
        char c = charArray[idx];
        charArray[idx] = charArray[index];
        charArray[index] = c;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        int[][] board = { { 4, 1, 2 }, { 5, 0, 3 } };
        P773_SlidingPuzzle pp = new P773_SlidingPuzzle();
        int step = pp.slidingPuzzle(board);
        System.out.println(step);

    }
}
