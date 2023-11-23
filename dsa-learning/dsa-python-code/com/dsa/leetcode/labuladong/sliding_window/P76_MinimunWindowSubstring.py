# author: tobebetter9527
# since: 2023/11/23 17:54
from collections import defaultdict


class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if not s or not t or len(s) < len(t):
            return ""
        need, window = defaultdict(int), defaultdict(int)
        for c in t:
            need[c] += 1

        left, right, validSize = 0, 0, 0
        start, length = 0, float('inf')

        while right < len(s):
            # expand window
            c = s[right]
            right += 1
            if c in need:
                window[c] += 1
                if need[c] == window[c]:
                    validSize += 1

            # shrink window
            while validSize == len(need):
                if right - left < length:
                    start = left
                    length = right - left
                cc = s[left]
                left += 1
                if cc in need:
                    if need[cc] == window[cc]:
                        validSize -= 1
                    window[cc] -= 1

        return "" if length == float('inf') else s[start:start + length]
