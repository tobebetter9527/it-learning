# author: tobebetter9527
# since: 2023/11/20 17:37
from collections import deque
from typing import List


class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        if target == "0000":
            return 0
        dead = set(deadends)
        if "0000" in dead or target in dead:
            return -1
        q = deque()
        q.append("0000")
        step = 0

        while q:
            size = len(q)
            for i in range(size):
                lockStatus = q.popleft()
                if lockStatus == target:
                    return step
                neighbors = self.getNeighbors(lockStatus)
                for neighbor in neighbors:
                    if neighbor not in dead:
                        dead.add(neighbor)
                        q.append(neighbor)
            step += 1
        return -1

    def getNeighbors(self, lockStatus):
        neighbors = []
        chars = list(lockStatus)
        for i in range(4):
            temp = chars[i]
            chars[i] = self.addOne(temp)
            neighbors.append("".join(chars))
            chars[i] = self.minusOne(temp)
            neighbors.append("".join(chars))
            chars[i] = temp
        return neighbors

    def addOne(self, temp):
        return "0" if temp == "9" else str(int(temp) + 1)

    def minusOne(self, temp):
        return "9" if temp == "0" else str(int(temp) - 1)


if __name__ == '__main__':
    deadends = ["8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"]
    target = "8888"
    solu = Solution()
    print(solu.openLock(deadends, target))
