from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}
        for i in range(len(nums)):
            if target - nums[i] in map:
                return [i, map[target - nums[i]]]
            else:
                map[nums[i]] = i
        return None


if __name__ == '__main__':
    nums = [2, 7, 11, 15]
    target = 9
    solu = Solution()
    print(solu.twoSum(nums, target))
