package com.dsa.leetcode.labuladong2.list;

public class P19_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = getNthNode(n + 1, dummy);
        slow.next = slow.next.next;
        return dummy.next;
    }

    private ListNode getNthNode(int n, ListNode dummy) {
        ListNode fast = dummy, slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
