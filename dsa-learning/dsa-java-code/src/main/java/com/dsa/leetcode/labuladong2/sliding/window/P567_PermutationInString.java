package com.dsa.leetcode.labuladong2.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class P567_PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, len = s2.length();
        int validCount = 0;
        while (right < len) {
            char c = s2.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(needs.get(c))) {
                    validCount++;
                }
            }
            while (right - left >= s1.length()) {
                if (validCount == needs.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (needs.containsKey(d)) {
                    if (window.get(d).equals(needs.get(d))) {
                        validCount--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
