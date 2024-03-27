package com.dsa.leetcode.labuladong.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P95_UniquqeBinaryTreesII {

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        return build(1, n);
    }

    private List<TreeNode> build(int left, int right) {
        List<TreeNode> list = new LinkedList<>();
        if (left > right) {
            list.add(null);
            return list;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> leftTrees = build(left, i - 1);
            List<TreeNode> rightTrees = build(i + 1, right);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    list.add(root);
                }
            }
        }
        return list;
    }

}
