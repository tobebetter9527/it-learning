package com.dsa.leetcode.linked_list;


public class P21_MergeTwoSortedLists {
    /**
     * traverse
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
     * recursive
     *
     * @param list1
     * @param list2
     * @return 返回较小的node
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val >= list2.val) {
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        } else {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        }
    }
}
