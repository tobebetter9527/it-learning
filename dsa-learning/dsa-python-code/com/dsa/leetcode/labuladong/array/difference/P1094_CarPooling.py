from typing import List


class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        n = len(trips)
        maxVal = trips[0][2]
        for i in range(1, n):
            maxVal = max(maxVal, trips[i][2])

        diff = [0 for i in range(maxVal + 1)]
        for trip in trips:
            diff[trip[1]] += trip[0]
            diff[trip[2]] -= trip[0]

        count = 0
        for value in diff:
            count += value
            if count > capacity:
                return False
        return True
