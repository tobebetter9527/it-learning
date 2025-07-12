package com.dsa.leetcode.labuladong2.dc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class P241_DifferentWaysToAddParentheses {
    
    Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (map.containsKey(expression)) {
            return map.get(expression);
        }
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> res1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> res2 = diffWaysToCompute(expression.substring(i + 1));
                for (int integer : res1) {
                    for (int integer2 : res2) {
                        if (c == '+') {
                            ans.add(integer + integer2);
                        } else if (c == '-') {
                            ans.add(integer - integer2);
                        } else {
                            ans.add(integer * integer2);
                        }
                    }
                }
            }
        }
        if (ans.isEmpty()) {
            ans.add(Integer.parseInt(expression));
        }
        return ans;
    }
}
