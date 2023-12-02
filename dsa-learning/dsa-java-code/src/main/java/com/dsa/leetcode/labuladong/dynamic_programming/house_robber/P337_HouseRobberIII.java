package com.dsa.leetcode.labuladong.dynamic_programming.house_robber;

import com.dsa.leetcode.labuladong.binary_tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @since 2023/12/2 09:37
 */
public class P337_HouseRobberIII {

    public int rob(TreeNode root) {
        int[] dp =  dp(root);
        return Math.max(dp[0], dp[1]);
    }

    private int recursive2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // rob
        int p1 = root.val;
        if (root.left != null) {
            p1 += recursive2(root.left.left) + recursive2(root.left.right);
        }
        if (root.right != null) {
            p1 += recursive2(root.right.left) + recursive2(root.right.right);
        }
        // not rob
        int p2 = recursive2(root.left) + recursive2(root.right);
        return Math.max(p1, p2);
    }

    private int memorizationSearch(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        // rob
        int p1 = root.val;
        if (root.left != null) {
            p1 += memorizationSearch(root.left.left, map) + memorizationSearch(root.left.right, map);
        }
        if (root.right != null) {
            p1 += memorizationSearch(root.right.left, map) + memorizationSearch(root.right.right, map);
        }
        // not rob
        int p2 = memorizationSearch(root.left, map) + memorizationSearch(root.right, map);

        int res = Math.max(p1, p2);
        map.put(root, res);
        return res;
    }

    private int[] dp(TreeNode root) {
        // dp[0]表示不偷，dp[1]表示偷
        int[] dp = new int[2];
        if (root == null) {
            return dp;
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);

        // not rob
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0] ,right[1]);
        // rob
        dp[1] = root.val + left[0] + right[0];

        return dp;
    }


    /**
     * not a good recursion
     *
     * @param root
     * @param b    true表示可以偷，当可以决定偷或不偷；false表示一定不能偷
     */
    private int recursive1(TreeNode root, boolean b) {
        if (root == null) {
            return 0;
        }
        if (b) {
            // rob
            int p1 = root.val + recursive1(root.left, false) + recursive1(root.right, false);
            // not rob
            int p2 = recursive1(root.left, true) + recursive1(root.right, true);
            return Math.max(p1, p2);
        } else {
            return recursive1(root.left, true) + recursive1(root.right, true);
        }
    }



    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        P337_HouseRobberIII p337 = new P337_HouseRobberIII();
        System.out.println(p337.rob(node1));
    }


}
