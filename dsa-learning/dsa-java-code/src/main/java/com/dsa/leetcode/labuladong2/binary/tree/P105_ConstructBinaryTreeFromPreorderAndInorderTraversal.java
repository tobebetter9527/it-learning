package com.dsa.leetcode.labuladong2.binary.tree;

public class P105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preLow, int preHigh, int[] inorder, int inLow , int inHigh) {
        if (preLow > preHigh) {
            return null;
        }
        int val = preorder[preLow];
        TreeNode root = new TreeNode(val);
        int index = -1;
        for (int i = inLow; i <= inHigh; i++) {
            if (val == inorder[i]) {
                index = i;
                break;
            }
        }
        root.left = build(preorder, preLow + 1, preLow + (index - inLow), inorder, inLow, index - 1);
        root.right = build(preorder, preLow + (index - inLow) + 1, preHigh, inorder, index + 1, inHigh);
        return root;
    }
}
