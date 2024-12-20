package com.dsa.leetcode.labuladong.graph;

/**
 * @since 2024/6/24 20:49
 */
public class P277_FindTheCelebrity {
    /**
     * brute force, time complexity is O(n^2)
     *
     * @param n
     * @return
     */
    int findCelebrity1(int n) {
        for (int candidate = 0; candidate < n; candidate++) {
            int other;
            for (other = 0; other < n; other++) {
                // can't compare to oneself, candidate knows other, or other doesn't know candidate,
                // candidate is not a celebrity
                if (candidate != other || knows(candidate, other) || !knows(other, candidate)) {
                    break;
                }
            }
            // candidate compares to all,except himself or herself
            if (other == n) {
                return candidate;
            }
        }
        return -1;
    }

    int findCelebrity(int n) {
        // compare and eliminate one that is not celebrity.
        int candicate = 0;
        for (int other = 1; other < n; other++) {
            if (knows(candicate, other) || !knows(other, candicate)) {
                candicate = other;
            }
        }
        // check if the final candidate is the celebrity
        for (int other = 0; other < n; other++) {
            if (candicate != other || knows(candicate, other) || !knows(other, candicate)) {
                return -1;
            }
        }
        return candicate;
    }


    boolean knows(int one, int two) {
        return true;
    }
}
