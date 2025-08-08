package com.dsa.leetcode.labuladong2.queue_stack;

import java.util.LinkedList;
import java.util.Queue;

public class P225_ImplementStackUsingQueues {

    class MyStack {
        Queue<Integer> q1;
        Queue<Integer> q2;

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int x) {
            if (q1.isEmpty()) {
                q1.offer(x);
                while (!q2.isEmpty()) {
                    q1.offer(q2.poll());
                }
            } else {
                q2.offer(x);
                while (!q1.isEmpty()) {
                    q2.offer(q1.poll());
                }
            }
        }

        public int pop() {
            if (q1.isEmpty()) {
                return q2.poll();
            } else {
                return q1.poll();
            }
        }

        public int top() {
            if (q1.isEmpty()) {
                return q2.peek();
            } else {
                return q1.peek();
            }
        }

        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }
}
