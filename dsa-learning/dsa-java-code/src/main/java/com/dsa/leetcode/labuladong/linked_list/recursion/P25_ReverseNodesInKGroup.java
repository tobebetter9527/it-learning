package com.dsa.leetcode.labuladong.linked_list.recursion;

import com.dsa.leetcode.labuladong.linked_list.ListNode;

/**
 * @since 2023/12/7 20:28
 */
public class P25_ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode left = head, right = head;
        for (int i = 0; i < k; i++) {
            // 不足k个，需要提前返回
            if (right == null) {
                return head;
            }
            right = right.next;
        }

        ListNode newHead = reverseNode(left, right);
        head.next = reverseKGroup(right, k);
        return newHead;
    }

    private ListNode reverseNode(ListNode left, ListNode right) {
        ListNode pre = null, cur = left, next = null;
        while (cur != right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;

        ListNode left = head, right = head;
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < k; i++) {
                if (right == null) {
                    flag = false;
                    break;
                }
                right = right.next;
            }
            if (flag) {
                pre.next = reverseNode(left, right);
                pre = left;
                left = right;
            } else {
                pre.next = left;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(7);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        P25_ReverseNodesInKGroup p25 = new P25_ReverseNodesInKGroup();
        ListNode listNode = p25.reverseKGroup2(head, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
