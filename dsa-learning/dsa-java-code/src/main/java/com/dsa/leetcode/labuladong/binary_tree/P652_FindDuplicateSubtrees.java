package com.dsa.leetcode.labuladong.binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P652_FindDuplicateSubtrees {
    private Map<String, Integer> seen = new HashMap<>();
    private List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    private String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String str = left + "," + right + "," + root.val;
        Integer count = seen.getOrDefault(str, 0);
        // 说明已经重复
        if (count == 1) {
            res.add(root);
        }
        seen.put(str, count + 1);
        return str;
    }
}


