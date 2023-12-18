from typing import List
from collections import defaultdict


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        n, m = len(s), len(p)
        if n < m:
            return []
        need, window = defaultdict(int), defaultdict(int)
        for c in p:
            need[c] += 1
        left, right, valid = 0, 0, 0
        ans = []
        while right < n:
            # expand window
            c = s[right]
            right += 1
            if c in need:
                window[c] += 1
                if need[c] == window[c]:
                    valid += 1
            else:
                window.clear()
                left = right
                valid = 0
            # shrink window
            if right - left == m:
                if valid == len(need):
                    ans.append(left)
                d = s[left]
                left += 1
                if need[d] == window[d]:
                    valid -= 1
                window[d] -= 1
        return ans


if __name__ == '__main__':
    s = "cbaebabacd"
    p = "abc"
    solu = Solution()
    print(solu.findAnagrams(s, p))
