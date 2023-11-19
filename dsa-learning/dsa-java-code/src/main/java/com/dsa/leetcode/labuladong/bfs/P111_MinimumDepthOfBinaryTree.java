package com.dsa.leetcode.labuladong.bfs;

import com.dsa.leetcode.labuladong.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @since 2023/11/19 16:01
 */
public class P111_MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int minDepth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return minDepth + 1;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            minDepth++;
        }
        return minDepth;
    }


}
