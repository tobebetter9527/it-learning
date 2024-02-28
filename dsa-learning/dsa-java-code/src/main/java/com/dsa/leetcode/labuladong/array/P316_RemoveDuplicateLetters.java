package com.dsa.leetcode.labuladong.array;

import java.util.Stack;

public class P316_RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        // count letters
        int[] nums = new int[256];
        for (char c : s.toCharArray()) {
            nums[c]++;
        }

        // if letter in stack
        boolean[] inStack = new boolean[256];

        // 单调栈
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // minus letter
            nums[c]--;

            if (inStack[c]) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c) {
                if (nums[stack.peek()] == 0) {
                    break;
                }
                inStack[stack.pop()] = false;
            }

            stack.push(c);
            inStack[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public String removeDuplicateLetters2(String s) {
        int len = s.length();

        int[] lastOcc = new int[256];
        for (int i = 0; i < len; i++) {
            lastOcc[s.charAt(i)] = i;
        }

        boolean[] inStack = new boolean[256];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (!inStack[c]) {
                while (!stack.isEmpty() && stack.peek() > c && i < lastOcc[stack.peek()]) {
                    inStack[stack.pop()] = false;
                }
                stack.push(c);
                inStack[c] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public String removeDuplicateLetters3(String s) {
        int len = s.length();

        int[] lastOcc = new int[256];
        for (int i = 0; i < len; i++) {
            lastOcc[s.charAt(i)] = i;
        }

        boolean[] inStack = new boolean[256];
        StringBuilder stack = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (!inStack[c]) {
                while (stack.length() != 0 && stack.charAt(stack.length() - 1) > c
                        && i < lastOcc[stack.charAt(stack.length() - 1)]) {
                    inStack[stack.charAt(stack.length() - 1)] = false;
                    stack.deleteCharAt(stack.length() - 1);
                }
                stack.append(c);
                inStack[c] = true;
            }
        }

        return stack.toString();
    }

    public static void main(String[] args) {
        String str = "bcac";
        P316_RemoveDuplicateLetters p316 = new P316_RemoveDuplicateLetters();
        String s = p316.removeDuplicateLetters(str);
        System.out.println(s);

    }
}
