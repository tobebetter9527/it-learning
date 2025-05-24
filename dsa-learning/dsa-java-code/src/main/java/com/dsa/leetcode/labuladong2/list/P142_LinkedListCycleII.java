package com.dsa.leetcode.labuladong2.list;

public class P142_LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                flag = true;
                break;
            }
        }
        if (flag) {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }

        return null;
    }
}
