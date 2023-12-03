package com.dsa.leetcode.labuladong.linked_list.two_pointers;

import com.dsa.leetcode.labuladong.linked_list.ListNode;

import java.util.HashSet;
import java.util.Set;

public class P141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null && fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow == fast;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }

        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
