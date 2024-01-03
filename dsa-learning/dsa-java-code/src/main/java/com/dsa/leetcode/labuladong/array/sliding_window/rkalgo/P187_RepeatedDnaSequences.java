package com.dsa.leetcode.labuladong.array.sliding_window.rkalgo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P187_RepeatedDnaSequences {




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

}
