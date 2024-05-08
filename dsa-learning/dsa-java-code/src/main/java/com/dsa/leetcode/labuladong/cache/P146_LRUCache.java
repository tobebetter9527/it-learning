package com.dsa.leetcode.labuladong.cache;

import java.util.HashMap;
import java.util.Map;

public class P146_LRUCache {

    class LRUCache {
        int capacity;
        Map<Integer, Node> map;
        MyLinkedList cache;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            cache = new MyLinkedList();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            makeRecent(key);
            return map.get(key).val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                deleteKey(key);
                addRecent(key, value);
                return;
            }
            if (cache.size() == capacity) {
                removeLeastRecent();
            }
            addRecent(key, value);
        }

        private void removeLeastRecent() {
            Node node = cache.removeFirstNode();
            if (node != null) {
                map.remove(node.key);
            }
        }

        private void addRecent(int key, int value) {
            Node node = new Node(key, value);
            cache.addLast(node);
            map.put(key, node);
        }

        private void deleteKey(int key) {
            Node node = map.remove(key);
            cache.remove(node);
        }

        private void makeRecent(int key) {
            Node node = map.get(key);
            cache.remove(node);
            cache.addLast(node);
        }

        static class MyLinkedList {
            int size;
            Node head, tail;

            public MyLinkedList() {
                head = new Node(0, 0);
                tail = new Node(0, 0);
                head.next = tail;
                tail.prev = head;
                size = 0;
            }

            public void addLast(Node x) {
                x.next = tail;
                x.prev = tail.prev;
                tail.prev.next = x;
                tail.prev = x;
                size++;
            }

            public void remove(Node x) {
                x.prev.next = x.next;
                x.next.prev = x.prev;
                x.next = null;
                x.prev = null;
                size--;
            }

            public Node removeFirstNode() {
                if (head.next == tail) {
                    return null;
                }
                Node node = head.next;
                remove(node);
                return node;
            }

            public int size() {
                return size;
            }

        }


        static class Node {
            int key;
            int val;
            Node prev;
            Node next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }
}
