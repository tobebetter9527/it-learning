package com.dsa.leetcode.labuladong.linked_list;

import java.util.PriorityQueue;

public class P23_MergeKSortedLists {
    /**
     * divide and conquer
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (right - left == 1) {
            return mergeTwoSortedLists(lists[left], lists[right]);
        }
        int mid = (left + right) >> 1;
        return mergeTwoSortedLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    private ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                cur.next = list2;
                cur = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                cur = list1;
                list1 = list1.next;
            }
        }
        cur.next = list1 == null ? list2 : list1;
        return dummy.next;
    }

    /**
     * heap
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = node;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }

        return dummy.next;
    }


    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode cur = lists[0];
        for (int i = 1, len = lists.length; i < len; i++) {
            cur = mergeTwoSortedLists(cur, lists[i]);
        }
        return cur;
    }

}
