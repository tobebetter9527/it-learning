from typing import Optional

from com.dsa.leetcode.labuladong.linked_list.ListNode import ListNode


class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head:
            return None

        left, right = head, head
        for i in range(k):
            if not right:
                return head
            right = right.next

        newHead = self.reverseNode(left, right)
        head.next = self.reverseKGroup(right, k)
        return newHead

    def reverseNode(self, left, right):
        pre, cur, next = None, left, None
        while cur != right:
            next = cur.next
            cur.next = pre
            pre = cur
            cur = next
        return pre


if __name__ == '__main__':
    node6 = ListNode(7, None)
    node5 = ListNode(6, node6)
    node4 = ListNode(5, node5)
    node3 = ListNode(4, node4)
    node2 = ListNode(3, node3)
    node1 = ListNode(2, node2)
    head = ListNode(1, node1)
    solu = Solution()
    newHead = solu.reverseKGroup(head, 2)
    while newHead:
        print(newHead.val)
        newHead = newHead.next
