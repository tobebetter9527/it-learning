package com.dsa.leetcode.labuladong.array.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * @since 2023/11/25 18:53
 */
public class P3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0, n = s.length();
        int left = 0, right = 0;
        Map<Character, Integer> window = new HashMap<>();
        while (right < n) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 这个缩小窗口的条件非常精妙
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            max = Math.max(max, right - left);
        }
        return max;
    }


    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0, n = s.length();
        int left = 0, right = 0;
        Map<Character, Integer> window = new HashMap<>();
        int duplicate = 0;
        while (right < n) {
            // expand window
            char c = s.charAt(right);
            right++;
            if (window.containsKey(c) && window.get(c) == 1) {
                duplicate++;
            }
            window.put(c, window.getOrDefault(c, 0) + 1);
            // shrink window
            while (duplicate > 0) {
                char d = s.charAt(left);
                left++;
                if (window.get(d) == 2) {
                    duplicate--;
                }
                window.put(d, window.get(d) - 1);
            }
            if (duplicate == 0) {
                max = Math.max(max, right - left);
            }

        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        P3_LongestSubstringWithoutRepeatingCharacters p3 = new P3_LongestSubstringWithoutRepeatingCharacters();
        System.out.println(p3.lengthOfLongestSubstring(s));
    }
}
