package com.dsa.leetcode.labuladong.array.matrix;

public class P151_ReverseWordsInAString {
    public static void main(String[] args) {
        P151_ReverseWordsInAString p151 = new P151_ReverseWordsInAString();
        String s = p151.reverseWords("  hello world  ");
        System.out.println(s);
    }

    public String reverseWords(String s) {
        StringBuilder sb = trimSpace(s);
        revese(0, sb.length() - 1, sb);
        reverseEachWord(sb);
        return sb.toString();
    }

    private void reverseEachWord(StringBuilder sb) {
        int left = 0;
        int right = 0;
        int n = sb.length();
        while (right < n) {
            while (right < n && sb.charAt(right) != ' ') {
                right++;
            }
            revese(left, right - 1, sb);
            left = ++right;
        }
    }

    private void revese(int left, int right, StringBuilder sb) {
        char temp;
        while (left < right) {
            temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }

    private StringBuilder trimSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, n = s.length(); i < n; i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            while (i < n && s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
                i++;
            }
            sb.append(' ');
        }
        return sb.deleteCharAt(sb.length() - 1);
    }

    public String reverseWords2(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int right;

        char[] newChars = new char[n + 1];
        int index = 0;

        for (int left = n - 1; left >= 0; left--) {
            if (chars[left] == ' ') {
                continue;
            }
            // 不是空字符串
            right = left;
            while (left >= 0 && chars[left] != ' ') {
                left--;
            }
            // 复制字符串，注意这里的left + 1
            for (int i = left + 1; i <= right; i++) {
                newChars[index++] = chars[i];
            }
            newChars[index++] = ' ';
        }
        return String.valueOf(newChars, 0, index - 1);
    }
}
