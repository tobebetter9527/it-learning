package com.dsa.leetcode.labuladong.binary_tree;

import java.util.HashMap;
import java.util.Map;

public class P106_ConstructBinaryTreeFromInorderAndPostorderTraversal {

    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, 0, length - 1, postorder, 0, length - 1);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int idx = map.get(postorder[postEnd]);
        int length = idx - inStart;
        root.left = build(inorder, inStart, idx - 1, postorder, postStart, postStart + length - 1);
        root.right = build(inorder, idx + 1, inEnd, postorder, postStart + length, postEnd - 1);
        return root;
    }
}
