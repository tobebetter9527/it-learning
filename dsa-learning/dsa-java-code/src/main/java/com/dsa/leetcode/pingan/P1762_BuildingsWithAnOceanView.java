package com.dsa.leetcode.pingan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P1762_BuildingsWithAnOceanView {

    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) {
                list.add(heights[i]);
                max = heights[i];
            }
        }
        Collections.reverse(list);
        return list.stream().mapToInt(x -> x.intValue()).toArray();
    }

    
}
