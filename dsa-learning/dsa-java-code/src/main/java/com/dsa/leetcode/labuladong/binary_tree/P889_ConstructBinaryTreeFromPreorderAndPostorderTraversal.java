package com.dsa.leetcode.labuladong.binary_tree;

import java.util.HashMap;
import java.util.Map;

public class P889_ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    private Map<Integer, Integer> map;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int length = preorder.length;
        map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            map.put(postorder[i], i);
        }

        return build(preorder, 0, length - 1, postorder, 0, length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return root;
        }
        int leftVal = preorder[preStart + 1];
        int idx = map.get(leftVal);
        int length = idx - postStart;
        root.left = build(preorder, preStart + 1, preStart + 1 + length, postorder, postStart, idx);
        root.right = build(preorder, preStart + 1 + length + 1, preEnd, postorder, idx + 1, postEnd - 1);
        return root;
    }
}
