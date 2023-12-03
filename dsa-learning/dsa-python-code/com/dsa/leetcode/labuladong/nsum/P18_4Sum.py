from typing import List


class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        ans = []
        if len(nums) < 3:
            return ans
        nums.sort()
        lastThreeSum = nums[-3] + nums[-2] + nums[-1]
        lastTwoSum = nums[-2] + nums[-1]
        for a in range(len(nums) - 3):
            if a > 0 and nums[a] == nums[a - 1]:
                continue
            if nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3] > target:
                break
            if nums[a] + lastThreeSum < target:
                continue
            for b in range(a + 1, len(nums) - 2):
                if b > a + 1 and nums[b] == nums[b - 1]:
                    continue
                if nums[a] + nums[b] + nums[b + 1] + nums[b + 2] > target:
                    break
                if nums[a] + nums[b] + lastTwoSum < target:
                    continue
                left, right = b + 1, len(nums) - 1
                while left < right:
                    s = nums[a] + nums[b] + nums[left] + nums[right]
                    if s > target:
                        right -= 1
                        while left < right and nums[right] == nums[right + 1]:
                            right -= 1
                    elif s < target:
                        left += 1
                        while left < right and nums[left] == nums[left - 1]:
                            left += 1
                    else:
                        ans.append([nums[a], nums[b], nums[left], nums[right]])
                        right -= 1
                        while left < right and nums[right] == nums[right + 1]:
                            right -= 1
                        left += 1
                        while left < right and nums[left] == nums[left - 1]:
                            left += 1
        return ans


if __name__ == '__main__':
    nums = [1, -2, -5, -4, -3, 3, 3, 5]
    target = -11
    solu = Solution()
    print(solu.fourSum(nums, target))
