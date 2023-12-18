package com.dsa.leetcode.labuladong.array.sliding_window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @since 2023/11/24 21:52
 */
public class P567_PermutationInString {

    public boolean checkInclusion2(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        int m = s1.length();
        int n = s2.length();

        int[] need = new int[26];
        for (int i = 0; i < m; i++) {
            need[s1.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (need[i] > 0) {
                count++;
            }
        }

        int[] window = new int[26];
        int validSize = 0;
        int left = 0;
        int right = 0;

        while (right < n) {
            char c = s2.charAt(right);
            right++;
            if (need[c - 'a'] > 0) {
                window[c - 'a']++;
                if (need[c - 'a'] == window[c - 'a']) {
                    validSize++;
                }
            } else {
                validSize = 0;
                left = right;
                Arrays.fill(window, 0);
            }

            if (right - left == m) {
                if (validSize == count) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (window[d - 'a'] == need[d - 'a']) {
                    validSize--;
                }
                window[d - 'a']--;
            }
        }
        return false;
    }


    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> need = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int validSize = 0;
        int left = 0, right = 0;
        while (right < s2.length()) {
            // expand window
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 只在相等的时候加一个，因为字符可能会重复
                if (need.get(c).equals(window.get(c))) {
                    validSize++;
                }
            } else {
                // 必须是连续的
                window.clear();
                validSize = 0;
                left = right;
            }
            // shrink window, 固定窗口，可以用if
            if (right - left == s1.length()) {
                if (validSize == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (need.get(d).equals(window.get(d))) {
                    validSize--;
                }
                window.put(d, window.get(d) - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        P567_PermutationInString p567PermutationInString = new P567_PermutationInString();
        System.out.println(p567PermutationInString.checkInclusion2(s1, s2));

    }
}
