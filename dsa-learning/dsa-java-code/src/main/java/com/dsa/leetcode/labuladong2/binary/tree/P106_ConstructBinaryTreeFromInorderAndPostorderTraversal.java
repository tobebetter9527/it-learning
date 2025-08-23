package com.dsa.leetcode.labuladong2.binary.tree;

import com.dsa.leetcode.labuladong.binary_tree.TreeNode;

public class P106_ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inlow, int inhigh, int[] postorder, int postlow, int posthigh) {
        if (inlow > inhigh) {
            return null;
        }
        int val = postorder[posthigh];
        int index = -1;
        for (int i = inlow; i <= inhigh; i++) {
            if (val == inorder[i]) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(val);
        root.left = build(inorder, inlow, index - 1, postorder, postlow, postlow + (index - inlow) - 1);
        root.right = build(inorder, index + 1, inhigh, postorder, posthigh - (inhigh - index), posthigh -1);
        return root;
    }
}
