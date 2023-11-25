from collections import defaultdict


class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        m, n = len(s1), len(s2),
        if m > n:
            return False
        need, window = defaultdict(int), defaultdict(int)
        for c in s1:
            need[c] += 1
        left, right = 0, 0
        valid = 0

        while right < n:
            # expand window
            c = s2[right]
            right += 1
            if c in need:
                window[c] += 1
                if need[c] == window[c]:
                    valid += 1
            else:
                left = right
                valid = 0
                window.clear()

            # shrink window
            if right - left == m:
                if valid == len(need):
                    return True
                d = s2[left]
                left += 1
                if need[d] == window[d]:
                    valid -= 1
                window[d] -= 1
        return False


if __name__ == '__main__':
    s1 = "abc"
    s2 = "bbbca"
    solu = Solution()
    print(solu.checkInclusion(s1, s2))
