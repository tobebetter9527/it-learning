package com.dsa.leetcode.labuladong2.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class P3_LongestSubstringWithoutRepeatingCharacters {
   
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, len = s.length();
        int max = 0;
        Map<Character, Integer> window = new HashMap<>();
        while (right < len) {
            char c = s.charAt(right);
            right++;
            if (window.containsKey(c)) {
                window.put(c, window.get(c) + 1);
            } else {
                window.put(c, 1);
            }

            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }

            max = Math.max(max, right - left);
        }
        return max;
    }
}
