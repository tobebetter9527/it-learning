package com.dsa.leetcode.labuladong.array.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 设计为左闭右开区间，容易计算区间[left,right)
 * 2. 什么时候应该扩大window，应该更新哪些数据
 * 3. 什么时候应该缩小window，应该更新哪些数据
 */
public class P76_MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        // 这个字段用得妙
        int validSize = 0;

        int left = 0, right = 0;
        int start = 0, len = Integer.MAX_VALUE;

        while (right < s.length()) {
            // expand window
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // this is the key codes
                if (need.get(c).equals(window.get(c))) {
                    validSize++;
                }
            }
            // shrink window
            while (validSize == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char c1 = s.charAt(left);
                left++;
                if (need.containsKey(c1)) {
                    if (need.get(c1).equals(window.get(c1))) {
                        validSize--;
                    }
                    window.put(c1, window.get(c1) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String s = "a", t = "a";
        P76_MinimumWindowSubstring p76MinimumWindowSubstring = new P76_MinimumWindowSubstring();
        System.out.println(p76MinimumWindowSubstring.minWindow(s, t));
    }
}
