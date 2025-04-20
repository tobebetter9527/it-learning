package com.dsa.leetcode.labuladong2.list;

public class P707_DesignLinkedList {

    class MyLinkedList {
        Node head;
        Node tail;
        int size;

        public MyLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public int get(int index) {
            if (isNotPositionIndex(index)) {
                return -1;
            }
            Node node = getNode(index);
            return node.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (isPositionIndex(index)) {
                Node cur = getNode(index);
                Node prev = cur.prev;
                Node newNode = new Node(val);
                prev.next = newNode;
                cur.prev = newNode;
                newNode.prev = prev;
                newNode.next = cur;
                size++;
            }
            if (index == size) {
                Node newNode = new Node(val);
                Node prev = tail.prev;
                prev.next = newNode;
                tail.prev = newNode;
                newNode.prev = prev;
                newNode.next = tail;
                size++;
            }
        }

        public void deleteAtIndex(int index) {
            if (isPositionIndex(index)) {
                Node cur = getNode(index);
                Node prev = cur.prev;
                Node next = cur.next;
                prev.next = next;
                next.prev = prev;
                size--;
            }
        }

        public Node getNode(int index) {
            Node cur = head;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            return cur;
        }

        public void checkElementIndex(int index) {
            if (isNotPositionIndex(index)) {
                throw new IndexOutOfBoundsException();
            }
        }

        public boolean isPositionIndex(int index) {
            return index >= 0 && index < size;
        }

        public boolean isNotPositionIndex(int index) {
            return !isPositionIndex(index);
        }

        static class Node {

            int val;
            Node prev;
            Node next;

            public Node() {

            }

            public Node(int val) {
                this.val = val;
            }

            public Node(int val, Node prev, Node next) {
                this.val = val;
                this.prev = prev;
                this.next = next;
            }
        }
    }

}
