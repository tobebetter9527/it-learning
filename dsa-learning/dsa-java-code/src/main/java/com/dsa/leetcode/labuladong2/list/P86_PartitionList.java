package com.dsa.leetcode.labuladong2.list;

public class P86_PartitionList {

    public static ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        ListNode p = head;
        while (p != null) {
            ListNode temp = p;
            ListNode next = temp.next;
            temp.next = null;
            if (temp.val >= x) {
                p2.next = temp;
                p2 = p2.next;
            } else {
                p1.next = temp;
                p1 = p1.next;
            }
            p = next;
        }
        p1.next = dummy2.next;
        return dummy1.next;
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
        ListNode node = partition(node1, 3);
        System.out.println(node.val);

    }
}
