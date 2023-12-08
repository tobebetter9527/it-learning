# author: tobebetter9527
# since: 2023/11/3 9:35
from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i = 0
        for j in range(len(nums)):
            if nums[i] < nums[j]:
                i = i + 1
                nums[i] = nums[j]
        return i + 1


if __name__ == '__main__':
    nums = [0, 0, 1, 1, 2, 2]
    solu = Solution()
    print(solu.removeDuplicates(nums))
