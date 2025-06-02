class Solution:
    def findPalindrome(self, s, i, j):
        while i >= 0 and j < len(s):
            if s[i] == s[j]:
                i = i - 1
                j = j + 1
            else:
                break
        return i, j

    def longestPalindrome(self, s: str) -> str:
        max = 0
        start = 0
        end = 0
        for i in range(len(s)):
            left1, right1 = self.findPalindrome(s, i, i)
            left2, right2 = self.findPalindrome(s, i, i + 1)
            max1 = right1 - left1 + 1
            max2 = right2 - left2 + 1
            if max1 > max2 and max1 > max:
                start = left1
                end = right1
                max = max1
            elif max2 > max1 and max2 > max:
                start = left2
                end = right2
                max = max2
        return s[start + 1 : end]


if __name__ == "__main__":
    solu = Solution()
    s = "1233244"
    res = solu.longestPalindrome(s)
    print(res)
