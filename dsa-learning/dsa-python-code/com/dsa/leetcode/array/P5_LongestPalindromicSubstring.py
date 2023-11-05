class Solution:
    def expandAroundCenter(self, s, length, left, right):
        while left >= 0 and right < length and s[left] == s[right]:
            left -= 1
            right += 1
        return left + 1, right - 1

    def longestPalindrome(self, s: str) -> str:
        if not s:
            return ""
        start, end = 0, 0
        length = len(s)
        for i in range(length):
            left1, right1 = self.expandAroundCenter(s, length, i, i)
            left2, right2 = self.expandAroundCenter(s, length, i, i + 1)
            if right1 - left1 > end - start:
                start, end = left1, right1
            if right2 - left2 > end - start:
                start, end = left2, right2

        return s[start: end + 1]
