
from typing import List


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        slow = 0
        for i in range(1, len(nums)):
            if nums[slow] != nums[i]:
                slow = slow + 1
                nums[slow] = nums[i]
        return slow + 1
    
    
if __name__ == "__main__":
    solu = Solution()
    nums = [0,0,1,1,1,2,2,3,3,4]
    size = solu.removeDuplicates(nums)
    print(size)