package com.dsa.leetcode.labuladong2.binary.tree;

import java.util.LinkedList;
import java.util.List;

public class P144_BinaryTreePreorderTraversal {

    List<Integer> res = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
