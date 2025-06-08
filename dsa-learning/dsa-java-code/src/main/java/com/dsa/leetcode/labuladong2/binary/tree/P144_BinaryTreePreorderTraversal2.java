package com.dsa.leetcode.labuladong2.binary.tree;

import java.util.LinkedList;
import java.util.List;

public class P144_BinaryTreePreorderTraversal2 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }
}
