from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        ans, path = [], []
        used = [False for i in range(len(nums))]
        self.backtrack(nums, 0, used, ans, path)
        return ans

    def backtrack(self, nums, deep, used, ans, path):
        if deep == len(nums):
            ans.append(path[:])
            return
        for i in range(len(nums)):
            if not used[i]:
                used[i] = True
                path.append(nums[i])
                self.backtrack(nums, deep + 1, used, ans, path)
                path.pop()
                used[i] = False


if __name__ == '__main__':
    solu = Solution()
    print(solu.permute([1, 2, 3]))
