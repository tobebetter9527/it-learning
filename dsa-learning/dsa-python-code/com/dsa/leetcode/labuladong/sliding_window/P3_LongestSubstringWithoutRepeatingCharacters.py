from collections import defaultdict


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0
        n = len(s)
        ans, left, right = 0, 0, 0
        window = defaultdict(int)
        while right < n:
            # expand window
            c = s[right]
            right += 1
            window[c] += 1
            # shrink window
            while window[c] > 1:
                d = s[left]
                left += 1
                window[d] -= 1
            ans = max(ans, right - left)
        return ans


if __name__ == '__main__':
    s = "abcabcbb"
    solu = Solution()
    print(solu.lengthOfLongestSubstring(s))
