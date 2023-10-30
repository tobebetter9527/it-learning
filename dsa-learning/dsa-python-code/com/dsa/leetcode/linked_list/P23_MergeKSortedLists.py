# author: tobebetter9527
# since: 2023/10/30 17:02
from typing import List, Optional

from com.dsa.leetcode.linked_list import ListNode


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists:
            return None
        return self.merge(lists, 0, len(lists) - 1)

    def merge(self, lists, left, right):
        if left == right:
            return lists[left]
        if right - left == 1:
            return self.mergeTwoSortedLists(lists[left], lists[right])
        mid = (left + right) // 2
        return self.mergeTwoSortedLists(self.merge(lists, left, mid), self.merge(lists, mid + 1, right))

    def mergeTwoSortedLists(self, list1, list2):
        dummy = ListNode()
        cur = dummy
        while list1 and list2:
            if list1.val >= list2.val:
                cur.next = list2
                cur = list2
                list2 = list2.next
            else:
                cur.next = list1
                cur = list1
                list1 = list1.next
        cur.next = list1 if list1 else list2
        return dummy.next
