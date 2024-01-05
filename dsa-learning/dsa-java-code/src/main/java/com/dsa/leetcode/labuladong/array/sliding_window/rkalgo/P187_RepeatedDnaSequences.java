package com.dsa.leetcode.labuladong.array.sliding_window.rkalgo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class P187_RepeatedDnaSequences {
    /**
     * sliding window
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        int[] nums = transfer(s, n);

        int R = 4;
        int L = 10;
        int RL = (int) Math.pow(R, 10 - 1);
        Set<Integer> seen = new HashSet<>();
        Set<String> res = new HashSet<>();
        int window = 0;

        int left = 0, right = 0;
        while (right < n) {
            window = R * window + nums[right];
            right++;

            if (right - left == L) {
                if (seen.contains(window)) {
                    res.add(s.substring(left, right));
                } else {
                    seen.add(window);
                }
                window = window - nums[left] * RL;
                left++;
            }
        }
        return new ArrayList<>(res);
    }

    private static int[] transfer(String s, int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 'A':
                    nums[i] = 0;
                    break;
                case 'C':
                    nums[i] = 1;
                    break;
                case 'G':
                    nums[i] = 2;
                    break;
                case 'T':
                    nums[i] = 3;
                    break;
            }
        }
        return nums;
    }

    /**
     * 暴力法，time complexity is O(nl) , l指定字符串长度
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences1(String s) {
        int n = s.length();
        Set<String> seen = new HashSet<>();
        Set<String> ans = new HashSet<>();
        for (int i = 0; i + 10 <= n; i++) {
            String str = s.substring(i, i + 10);
            if (seen.contains(str)) {
                ans.add(str);
            } else {
                seen.add(str);
            }

        }
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        P187_RepeatedDnaSequences p187 = new P187_RepeatedDnaSequences();
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> repeatedDnaSequences = p187.findRepeatedDnaSequences(s);
        System.out.println(repeatedDnaSequences);


    }

}
