package com.dsa.leetcode.labuladong.linked_list.recursion;

import com.dsa.leetcode.labuladong.linked_list.ListNode;

/**
 * @since 2023/12/4 21:02
 */
public class P206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;

        P206_ReverseLinkedList p206 = new P206_ReverseLinkedList();
        ListNode listNode = p206.reverseList(head);
        System.out.println(listNode.val);

    }

}
