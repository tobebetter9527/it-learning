package com.dsa.leetcode.labuladong.linked_list.two_pointers;

import com.dsa.leetcode.labuladong.linked_list.ListNode;

/**
 * @since 2023/10/29 08:37
 */
public class P86_PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode newDummy = new ListNode();
        ListNode newCur = newDummy;

        ListNode oldDummy = new ListNode();
        ListNode oldCur = oldDummy;

        while (head != null) {
            if (head.val >= x) {
                oldCur.next = head;
                oldCur = head;
            } else {
                newCur.next = head;
                newCur = head;
            }
            head = head.next;
        }
        // very important, if not, there is a cycle
        oldCur.next = null;
        newCur.next = oldDummy.next;
        return newDummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        P86_PartitionList p81PartitionList = new P86_PartitionList();
        ListNode partition = p81PartitionList.partition(node1, 3);
        System.out.println(partition.val);
    }
}
