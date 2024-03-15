# author: tobebetter9527
# since: 2024/3/15 16:41
from typing import List


class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        if not nums:
            return []
        self.temp = [(0, 0) for _ in range(len(nums))]
        pairs = [(num, idx) for idx, num in enumerate(nums)]
        count = [0 for _ in range(len(nums))]
        self.merge_sort(pairs, 0, len(nums) - 1, count)
        return count

    def merge_sort(self, pairs, left, right, count):
        if left == right:
            return
        mid = left + (right - left) // 2
        self.merge_sort(pairs, left, mid, count)
        self.merge_sort(pairs, mid + 1, right, count)
        self.merge(pairs, left, mid, right, count)

    def merge(self, pairs, left, mid, right, count):
        for i in range(left, right + 1):
            self.temp[i] = pairs[i]
        temp = self.temp

        idx = left
        i, j = left, mid + 1
        while i <= mid and j <= right:
            if temp[i][0] <= temp[j][0]:
                pairs[idx] = temp[i]
                count[temp[i][1]] += j - mid - 1
                idx += 1
                i += 1
            else:
                pairs[idx] = temp[j]
                idx += 1
                j += 1
        while i <= mid:
            count[temp[i][1]] += j - mid - 1
            pairs[idx] = temp[i]
            idx += 1
            i += 1
        while j <= right:
            pairs[idx] = temp[j]
            idx += 1
            j += 1


if __name__ == '__main__':
    nums = [5, 2, 6, 1]
    solu = Solution()
    res = solu.countSmaller(nums)
    print(res)
