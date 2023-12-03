package com.dsa.leetcode.labuladong.linked_list.two_pointers;

import com.dsa.leetcode.labuladong.linked_list.ListNode;

public class P876_MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

