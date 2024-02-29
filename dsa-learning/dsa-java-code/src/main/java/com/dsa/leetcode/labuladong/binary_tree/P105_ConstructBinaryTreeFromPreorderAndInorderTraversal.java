package com.dsa.leetcode.labuladong.binary_tree;

import java.util.HashMap;
import java.util.Map;

public class P105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, length - 1, inorder, 0, length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int idx = map.get(preorder[preStart]);
        int size = idx - inStart;
        root.left = build(preorder, preStart + 1, preStart + size, inorder, inStart, idx - 1);
        root.right = build(preorder, preStart + size + 1, preEnd, inorder, idx + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        P105_ConstructBinaryTreeFromPreorderAndInorderTraversal p105 = new P105_ConstructBinaryTreeFromPreorderAndInorderTraversal();
        TreeNode treeNode = p105.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}
