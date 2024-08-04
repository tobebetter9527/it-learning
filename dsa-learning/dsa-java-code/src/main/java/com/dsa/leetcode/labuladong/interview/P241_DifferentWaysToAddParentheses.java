package com.dsa.leetcode.labuladong.interview;

import java.util.*;

/**
 * @since 2024/8/3 22:32
 */
public class P241_DifferentWaysToAddParentheses {

    Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (map.containsKey(expression)) {
            return map.get(expression);
        }

        List<Integer> res = new LinkedList<>();
        for (int i = 0, len = expression.length(); i < len; i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> leftList = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightList = diffWaysToCompute(expression.substring(i + 1));
                for (Integer left : leftList) {
                    for (Integer right : rightList) {
                        if (c == '+') {
                            res.add(left + right);
                        } else if (c == '-') {
                            res.add(left - right);
                        } else {
                            res.add(left * right);
                        }
                    }
                }
            }
        }

        if (res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }
        map.put(expression, res);
        return res;
    }

    public static void main(String[] args) {
        String exp = "2*3-4*5";
        P241_DifferentWaysToAddParentheses p241 = new P241_DifferentWaysToAddParentheses();
        System.out.println(p241.diffWaysToCompute(exp));

    }

}
