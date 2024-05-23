package com.dsa.leetcode.labuladong.cache;

import java.util.HashMap;
import java.util.Map;

public class P460_LFUCache {

    class LFUCache {
        int minFreq, capacity;
        Map<Integer, Node> keyTable;
        Map<Integer, DoubleLinkedList> freqTable;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            keyTable = new HashMap<>();
            freqTable = new HashMap<>();
        }

        public int get(int key) {
            if (capacity == 0) {
                return -1;
            }
            if (!keyTable.containsKey(key)) {
                return -1;
            }
            Node node = keyTable.get(key);
            // remove the node in the old double linked list, update minFreq
            DoubleLinkedList oldList = freqTable.get(node.freq);
            oldList.remove(node);
            if (oldList.isEmpty()) {
                freqTable.remove(node.freq);
                if (node.freq == minFreq) {
                    minFreq++;
                }
            }

            // insert the node into new double linked list, increase freq
            node.freq += 1;
            DoubleLinkedList list = freqTable.getOrDefault(node.freq, new DoubleLinkedList());
            list.addHead(node);
            freqTable.put(node.freq, list);

            return node.val;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (!keyTable.containsKey(key)) {
                if (capacity == keyTable.size()) {
                    DoubleLinkedList list = freqTable.get(minFreq);
                    Node tail = list.getTail();
                    list.remove(tail);
                    keyTable.remove(tail.key);
                    if (list.isEmpty()) {
                        freqTable.remove(minFreq);
                    }
                }

                Node node = new Node(key, value, 1);
                keyTable.put(key, node);
                minFreq = 1;
                DoubleLinkedList list = freqTable.getOrDefault(minFreq, new DoubleLinkedList());
                list.addHead(node);
                freqTable.put(minFreq, list);
            } else {
                Node node = keyTable.get(key);
                node.val = value;

                DoubleLinkedList oldList = freqTable.get(node.freq);
                oldList.remove(node);
                if (oldList.isEmpty()) {
                    freqTable.remove(node.freq);
                    if (node.freq == minFreq) {
                        minFreq++;
                    }
                }

                node.freq += 1;
                DoubleLinkedList list = freqTable.getOrDefault(node.freq, new DoubleLinkedList());
                list.addHead(node);
                freqTable.put(node.freq, list);
            }
        }

        private class Node {
            int key, val, freq;
            Node prev, next;

            public Node() {

            }

            public Node(int key, int val, int freq) {
                this.key = key;
                this.val = val;
                this.freq = freq;
            }
        }

        private class DoubleLinkedList {
            private Node head, tail;
            private int size;

            public DoubleLinkedList() {
                size = 0;
                head = new Node();
                tail = new Node();
                head.next = tail;
                tail.prev = head;
            }

            public void addHead(Node node) {
                Node temp = head.next;
                head.next = node;
                node.prev = head;
                node.next = temp;
                temp.prev = node;
                size++;
            }

            public void remove(Node node) {
                Node prev = node.prev;
                Node next = node.next;
                prev.next = next;
                next.prev = prev;
                node.prev = null;
                node.next = null;
                size--;
            }

            public Node getHead() {
                return head.next;
            }

            public Node getTail() {
                return tail.prev;
            }

            public int size() {
                return size;
            }

            public boolean isEmpty() {
                return size() == 0;
            }
        }
    }
}
