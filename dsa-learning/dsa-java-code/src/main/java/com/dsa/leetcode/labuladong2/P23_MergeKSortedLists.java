package com.dsa.leetcode.labuladong2;

import java.util.PriorityQueue;

import com.dsa.leetcode.labuladong.linked_list.ListNode;

public class P23_MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((x,y)->(x.val - y.val));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.add(listNode);
            }
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            if (node.next != null) {
                queue.add(node.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
}
