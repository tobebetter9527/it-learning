package com.dsa.leetcode.labuladong.linked_list.recursion;

import com.dsa.leetcode.labuladong.linked_list.ListNode;

public class P234_PalindromeLinkedList {
    ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return recursive(head);
    }

    private boolean recursive(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean res = recursive(right.next);
        res = res && (left.val == right.val);
        left = left.next;
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        P234_PalindromeLinkedList p234 = new P234_PalindromeLinkedList();
        boolean palindrome = p234.isPalindrome(head);
        System.out.println(palindrome);
    }

}
