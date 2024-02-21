# author: tobebetter9527
# since: 2024/2/21 8:49
import random
from typing import List


class Solution:

    def __init__(self, n: int, blacklist: List[int]):
        bound = n - len(blacklist)
        self.bound = bound

        black = set()
        for b in blacklist:
            if b >= bound:
                black.add(b)

        w = bound
        b2w = {}
        for b in blacklist:
            if b < bound:
                while w in black:
                    w += 1
                b2w[b] = w
                w += 1
        self.b2w = b2w

    def pick(self) -> int:
        x = random.randrange(self.bound)
        return self.b2w.get(x, x)
