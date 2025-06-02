package com.dsa.leetcode.labuladong2.array;

public class P5_LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] arr1 = findPalindrome(s, i, i);
            int[] arr2 = findPalindrome(s, i, i + 1);
            int max1 = arr1[1] - arr1[0] + 1;
            int max2 = arr2[1] - arr2[0] + 1;
            if (max1 > max2 && max1 > max) {
                start = arr1[0];
                end = arr1[1];
                max = max1;
            } else if (max1 < max2 && max2 > max) {
                start = arr2[0];
                end = arr2[1];
                max = max2;
            }
        }

        return s.substring(start + 1, end);
    }

    public int[] findPalindrome(String s, int i, int j) {
        int len = s.length();
        while (i >= 0 && j < len) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return new int[] { i, j };
    }

    public static void main(String[] args) {
       P5_LongestPalindromicSubstring p5 = new P5_LongestPalindromicSubstring();
       String str = "1232";
       String res = p5.longestPalindrome(str);
       System.out.println(res);

    }
}
