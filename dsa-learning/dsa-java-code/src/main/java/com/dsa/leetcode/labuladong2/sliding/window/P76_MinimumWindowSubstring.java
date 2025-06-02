package com.dsa.leetcode.labuladong2.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class P76_MinimumWindowSubstring {

    public static void main(String[] args) {
        String str = "a";
        String t = "aa";
        String res = minWindow(str, t);
        System.out.println(res);
    }

    public static String minWindow(String s, String t) {
        int left = 0, right = 0, length = s.length();

        Map<Character, Integer> data = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            data.put(c, data.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int len = Integer.MAX_VALUE;
        int start = 0;
        while (right < length) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            right++;

            while (left < right && isMatch(window, data)) {
                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                if (len > (right - left)) {
                    len = right - left;
                    start = left;
                }
                left++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    private static boolean isMatch(Map<Character, Integer> window, Map<Character, Integer> data) {
        for (Map.Entry<Character, Integer> entry : data.entrySet()) {
            int count = window.getOrDefault(entry.getKey(), 0);
            if (entry.getValue() > count) {
                return false;
            }
        }
        return true;
    }
}
