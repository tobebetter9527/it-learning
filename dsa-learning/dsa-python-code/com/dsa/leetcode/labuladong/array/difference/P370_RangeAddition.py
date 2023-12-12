from typing import List


class Difference:
    def __init__(self, nums: List[int]):
        n = len(nums)
        self.diff = [0 for i in range(n)]
        _diff = self.diff
        _diff[0] = nums[0]
        for i in range(1, n):
            _diff[i] = nums[i] - nums[i - 1]

    def increment(self, i: int, j: int, val: int):
        self.diff[i] += val
        if j + 1 < len(self.diff):
            self.diff[j + 1] -= val

    def result(self) -> List[int]:
        n = len(self.diff)
        nums = [0 for i in range(n)]
        nums[0] = self.diff[0]
        for i in range(1, n):
            nums[i] = nums[i - 1] + self.diff[i]
        return nums

if __name__ == '__main__':
    nums = [0 for i in range(5)]
    upddates = [[1, 3, 2], [2, 4, 3], [0, 2, -2]]
    df = Difference(nums)
    for upddate in upddates:
        df.increment(upddate[0], upddate[1], upddate[2])
    ans = df.result()
    print(ans)
