package com.dsa.leetcode.labuladong.array.randomized;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class P380_InsertDeleteGetRandom {

    static class RandomizedSet {
        private List<Integer> nums;

        private Map<Integer, Integer> indices;

        private Random random;
        public RandomizedSet() {
            nums = new ArrayList<>();
            indices = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (indices.containsKey(val)) {
                return false;
            }
            indices.put(val, nums.size());
            nums.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!indices.containsKey(val)) {
                return false;
            }
            int index = indices.get(val);
            int last = nums.get(nums.size() - 1);
            nums.set(index, last);
            nums.remove(nums.size() - 1);
            indices.put(last, index);
            indices.remove(val);
            return true;
        }

        public int getRandom() {
            int i = random.nextInt(nums.size());
            return nums.get(i);
        }
    }
}
