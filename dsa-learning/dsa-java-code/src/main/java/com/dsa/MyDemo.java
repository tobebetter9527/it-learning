package com.dsa;

public class MyDemo {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(20));

    }

    public static int nthUglyNumber(int n) {
        // 可以理解为三个指向有序链表头结点的指针
        int p2 = 1, p3 = 1, p5 = 1;
        // 可以理解为三个有序链表的头节点的值
        int product2 = 1, product3 = 1, product5 = 1;
        // 可以理解为最终合并的有序链表（结果链表）
        int[] ugly = new int[n + 1];
        // 可以理解为结果链表上的指针
        int p = 1;

        // 开始合并三个有序链表，找到第 n 个丑数时结束
        while (p <= n) {
            // 取三个链表的最小结点
            int min = Math.min(Math.min(product2, product3), product5);
            // 将最小节点接到结果链表上
            ugly[p] = min;
            p++;
            // 前进对应有序链表上的指针
            if (min == product2) {
                product2 = 2 * p2;
                p2++;
            }
            if (min == product3) {
                product3 = 3 * p3;
                p3++;
            }
            if (min == product5) {
                product5 = 5 * p5;
                p5++;
            }
        }
        // 返回第 n 个丑数
        return ugly[n];
    }
}
