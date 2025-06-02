package com.dsa.leetcode.labuladong2.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class P76_MinimumWindowSubstring2 {

    public String minWindow(String s, String t) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int sLen = s.length();
        int start = 0;
        int len = Integer.MAX_VALUE;

        int left = 0, right = 0, validCount = 0, tSize = needs.size();
        while (right < sLen) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (needs.containsKey(c)) {
                if (window.get(c).equals(needs.get(c))) {
                    validCount++;
                }
            }

            while (validCount == tSize) {
                if (len > (right - left)) {
                    len = right - left;
                    start = left;
                }
                char cc = s.charAt(left);
                left++;
                if (needs.containsKey(cc)) {
                    if (window.get(cc).equals(needs.get(cc))) {
                        validCount--;
                    }
                    window.put(cc, window.get(cc) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
