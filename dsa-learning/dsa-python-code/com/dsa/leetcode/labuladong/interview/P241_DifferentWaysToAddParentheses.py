from typing import List


class Solution:
    def __init__(self):
        self.map = {}

    def diffWaysToCompute(self, expression: str) -> List[int]:
        if expression in self.map:
            return self.map[expression]

        res = []
        if expression.isdigit():
            res.append(int(expression))
            return res
        for i in range(len(expression)):
            c = expression[i]
            if c in ('+', '-', '*'):
                left_list = self.diffWaysToCompute(expression[:i])
                right_list = self.diffWaysToCompute(expression[i + 1:])
                for left in left_list:
                    for right in right_list:
                        if c == '+':
                            res.append(left + right)
                        elif c == '-':
                            res.append(left - right)
                        else:
                            res.append(left * right)
        self.map[expression] = res
        return res


if __name__ == '__main__':
    exp = "2*3-4*5"
    solu = Solution()
    print(solu.diffWaysToCompute(exp))
