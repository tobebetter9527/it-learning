package com.dsa.leetcode.labuladong.array.randomized;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class P710_RandomPickWithBlacklist {

    class Solution {
        private Map<Integer, Integer> b2w;
        private int bound;
        private Random random;

        public Solution(int n, int[] blacklist) {
            random = new Random();
            bound = n - blacklist.length;

            Set<Integer> black = new HashSet<>();
            for (int b : blacklist) {
                if (b >= bound) {
                    black.add(b);
                }
            }

            Integer w = bound;
            b2w = new HashMap<>();
            for (int b : blacklist) {
                if (b < bound) {
                    while (black.contains(w)) {
                        w++;
                    }
                    b2w.put(b, w);
                    w++;
                }
            }
        }

        public int pick() {
            int x = random.nextInt(bound);
            return b2w.getOrDefault(x, x);
        }
    }
}
