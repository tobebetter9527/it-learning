import math
from typing import List


class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        n = len(s)
        nums = []
        for i in range(n):
            if s[i] == 'A':
                nums.append(0)
            elif s[i] == 'C':
                nums.append(1)
            elif s[i] == 'G':
                nums.append(2)
            elif s[i] == 'T':
                nums.append(3)
        seen = set()
        ans = set()
        left, right = 0, 0
        window = 0
        L = 10
        R = 4
        RL = math.pow(R, L - 1)

        while right < n:
            window = R * window + nums[right]
            right += 1

            if right - left == L:
                if window in seen:
                    ans.add(s[left:right])
                else:
                    seen.add(window)
                window = window - nums[left] * RL
                left += 1
        return list(ans)


if __name__ == '__main__':
    s = 'AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT'
    solu = Solution()
    print(solu.findRepeatedDnaSequences(s))


