package com.dsa.leetcode.labuladong.binary_tree;

import java.util.LinkedList;

public class P297_SerializeAndDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append('#').append(',');
            return;
        }
        sb.append(root.val).append(',');
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        LinkedList<String> list = new LinkedList<>();
        for (String s : split) {
            list.add(s);
        }
        return build(list);
    }

    private TreeNode build(LinkedList<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        String val = list.removeFirst();
        if ("#".equals(val)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = build(list);
        root.right = build(list);
        return root;
    }
}
