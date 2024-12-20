package com.dsa.leetcode.labuladong.graph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @since 2024/7/5 21:57
 */
public class P990_SatisfiabilityOfEqualityEquations {

    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                uf.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                if (uf.isConnected(equation.charAt(0) - 'a', equation.charAt(3) - 'a')) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // String[] equations = {"a==b", "b!=a"};
        String[] equations = {"a==b", "b==a"};
        P990_SatisfiabilityOfEqualityEquations p990 = new P990_SatisfiabilityOfEqualityEquations();
        boolean b = p990.equationsPossible(equations);
        System.out.println(b);

    }
}
