class CelebrityFinder:
    def findCelebrity(self, n: int) -> int:
        candidate = 0
        for other in range(1, n):
            if self.knows(candidate, other) or not self.knows(other, candidate):
                candidate = other
        for other in range(n):
            if candidate != other or self.knows(candidate,other) or not self.knows(other,candidate):
                return -1
        return candidate

    def knows(self, one: int, two: int) -> bool:
        pass
