package com.dsa.leetcode.labuladong2.sliding.window;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class P438_FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "abab", p = "ab";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        List<Integer> res = new LinkedList<>();
        int left = 0, right = 0, len = s.length();
        int validCount = 0;
        while (right < len) {
            char c = s.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(needs.get(c))) {
                    validCount++;
                }
            }

            while (right - left >= p.length()) {
                if (validCount == needs.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (needs.containsKey(d)) {
                    if (window.get(d).equals(needs.get(d))) {
                        validCount--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }
}
