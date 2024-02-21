# author: tobebetter9527
# since: 2024/2/21 14:37
class Solution:
    def removeDuplicateLetters(self, s: str) -> str:
        last_occ = {}
        in_stack = set()
        stack = []

        length = len(s)
        for i in range(length):
            last_occ[s[i]] = i

        for i in range(length):
            if s[i] not in in_stack:
                while stack and stack[-1] > s[i] and i < last_occ[stack[-1]]:
                    in_stack.remove(stack.pop())
                stack.append(s[i])
                in_stack.add(s[i])
        return "".join(stack)


if __name__ == '__main__':
    s = "bcac"
    solu = Solution()
    print(solu.removeDuplicateLetters(s))
