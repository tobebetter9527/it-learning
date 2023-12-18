package com.dsa.leetcode.labuladong.array.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @since 2023/11/25 10:36
 */
public class P438_FindAllAnagramsInaString {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        if (n < m) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();

        Map<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0;

        while (right < n) {
            // expand window
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            } else {
                window.clear();
                valid = 0;
                left = right;
            }

            // shrink window
            if (right - left == m) {
                if (valid == need.size()) {
                    ans.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.get(d).equals(window.get(d))) {
                    valid--;
                }
                window.put(d, window.get(d) - 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abaacbabc", p = "abc";
        P438_FindAllAnagramsInaString find = new P438_FindAllAnagramsInaString();
        System.out.println(find.findAnagrams(s, p));
    }
}
