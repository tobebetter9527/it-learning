class Solution:
    def reverseWords(self, s: str) -> str:
        words = self.trimSpaces(s)
        self.reverse(0, len(words) - 1, words)
        self.reverseEachWord(words)
        return "".join(words)

    def trimSpaces(self, s: str):
        words = []
        n, i = len(s), 0
        while i < n:
            if s[i] != " ":
                while i < n and s[i] != " ":
                    words.append(s[i])
                    i += 1
                words.append(" ")
            i += 1
        return words[0:len(words) - 1]

    def reverse(self, left, right, words):
        while left < right:
            temp = words[left]
            words[left] = words[right]
            words[right] = temp
            left += 1
            right -= 1

    def reverseEachWord(self, words):
        n = len(words)
        left, right = 0, 0
        while right < n:
            while right < n and words[right] != " ":
                right += 1
            self.reverse(left, right - 1, words)
            right += 1
            left = right


if __name__ == '__main__':
    s = "  hello world  "
    solu = Solution()
    words = solu.reverseWords(s)
    print(words)
