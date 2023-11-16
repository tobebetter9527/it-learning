package com.dsa.leetcode.labuladong.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P51_NQueens {

    List<List<String>> result = new ArrayList<>();
    List<Integer> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        backtrack(0, n);
        return result;
    }

    private void backtrack(int row, int n) {
        if (row == n) {
            result.add(makeList(res, n));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isAvailable(res, row, col)) {
                res.add(col);
                backtrack(row + 1, n);
                res.remove(res.size() - 1);
            }
        }
    }

    private boolean isAvailable(List<Integer> res, int row, int col) {
        for (int i = 0; i < res.size(); i++) {
            // 如果列相同，或者在同一斜线上
            if (res.get(i) == col || Math.abs(row - i) == Math.abs(col - res.get(i))) {
                return false;
            }
        }
        return true;
    }

    private List<String> makeList(List<Integer> res, int n) {
        List<String> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[res.get(i)] = 'Q';
            list.add(String.valueOf(chars));
        }
        return list;
    }


}
