package com.dsa.leetcode.labuladong.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @since 2023/11/18 11:56
 */
public class P77_Combinations {
    List<List<Integer>> ans = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1, 0);
        return ans;
    }

    private void backtrack(int n, int k, int start, int deep) {
        if (k == deep) {
            ans.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(n, k, i + 1, deep + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        P77_Combinations combinations = new P77_Combinations();
        System.out.println(combinations.combine(4, 2));
    }
}
