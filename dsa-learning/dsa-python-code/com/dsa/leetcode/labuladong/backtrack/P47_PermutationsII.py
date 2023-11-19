from typing import List


class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        ans, path = [], []
        used = [False for i in range(len(nums))]
        nums.sort()
        self.backtrack(nums, used, path, ans)
        return ans

    def backtrack(self, nums, used, path, ans):
        if len(path) == len(nums):
            ans.append(path[:])
            return
        for i in range(len(nums)):
            if used[i]:
                continue
            if i > 0 and not used[i - 1] and nums[i - 1] == nums[i]:
                continue
            used[i] = True
            path.append(nums[i])
            self.backtrack(nums, used, path, ans)
            path.pop()
            used[i] = False


if __name__ == '__main__':
    nums = [1, 2, 1]
    solu = Solution()
    print(solu.permuteUnique(nums))
