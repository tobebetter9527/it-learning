from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        sorted(nums)
        n = len(nums) - 2
        ans = []
        for i in range(n):
            if nums[i] > 0:
                break
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            j = i + 1
            k = len(nums) - 1
            while j < k:
                s = nums[i] + nums[j] + nums[k]
                if s > 0:
                    k -= 1
                    while j < k and nums[k] == nums[k + 1]:
                        k -= 1
                elif s < 0:
                    j += 1
                    while j < k and nums[j] == nums[j - 1]:
                        j += 1
                else:
                    ans.append([nums[i], nums[j], nums[k]])
                    k -= 1
                    j += 1
                    while j < k and nums[k] == nums[k + 1]:
                        k -= 1
                    while j < k and nums[j] == nums[j - 1]:
                        j += 1
        return ans
