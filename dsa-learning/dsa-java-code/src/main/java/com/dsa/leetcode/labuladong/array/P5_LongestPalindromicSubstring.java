package com.dsa.leetcode.labuladong.array;

/**
 * @since 2023/11/5 08:57
 */
public class P5_LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0, length = s.length(); i < length; i++) {
            int len1 = expandAroundCenter(s, length, i, i);
            int len2 = expandAroundCenter(s, length, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String str, int length, int left, int right) {
        while (left >= 0 && right < length && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}
