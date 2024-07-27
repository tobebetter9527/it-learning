package com.dsa.leetcode.labuladong.math;

import com.dsa.leetcode.labuladong.linked_list.ListNode;

import java.util.Random;

/**
 * @since 2024/7/27 16:14
 */
public class P382_LinkedListRandomNode {

    class Solution {
        ListNode head;
        Random random;
        public Solution(ListNode head) {
            this.head = head;
            random = new Random();
        }

        public int getRandom() {
            int i = 1, res = 0;
            ListNode cur = head;
            while (cur != null) {
                if (random.nextInt(i) == 0) {
                    res = cur.val;
                }
                i++;
                cur = cur.next;
            }
            return res;
        }
    }



}
