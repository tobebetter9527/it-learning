from typing import List


class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        left, right = 0, len(numbers) - 1
        while left < right:
            temp = numbers[left] + numbers[right]
            if temp > target:
                right -= 1
            elif temp < target:
                left += 1
            else:
                return [left + 1, right + 1]
        return None
