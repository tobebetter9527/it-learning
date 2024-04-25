package com.dsa.leetcode.labuladong.stack;

import java.util.Stack;

public class P232_ImplementQueueUsingStacks {

    class MyQueue {
        Stack<Integer> in;
        Stack<Integer> out;

        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            peek();
            return out.pop();
        }

        public int peek() {
            if (out.empty()) {
                while (!in.empty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }

        public boolean empty() {
            return in.empty() && out.empty();
        }
    }


}
