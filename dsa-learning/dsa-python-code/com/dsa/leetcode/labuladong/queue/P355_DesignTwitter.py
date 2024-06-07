import heapq
from typing import List


class Twitter:
    timestamp = 1

    def __init__(self):
        self.user_map = {}

    def postTweet(self, userId: int, tweetId: int) -> None:
        if userId not in self.user_map:
            self.user_map[userId] = User(userId)
        self.user_map[userId].postTweet(tweetId)

    def getNewsFeed(self, userId: int) -> List[int]:
        if userId not in self.user_map:
            return []
        user = self.user_map[userId]
        heap = []
        for followeeId in user.followed:
            if followeeId in self.user_map:
                follow_user = self.user_map[followeeId]
                if follow_user.head is not None:
                    heapq.heappush(heap, (-follow_user.head.timestamp, follow_user.head))
        res = []
        while heap and len(res) < 10:
            _, tweet = heapq.heappop(heap)
            res.append(tweet.tweetId)
            if tweet.next is not None:
                heapq.heappush(heap, (-tweet.next.timestamp, tweet.next))
        return res

    def follow(self, followerId: int, followeeId: int) -> None:
        if followerId not in self.user_map:
            self.user_map[followerId] = User(followerId)
        if followeeId not in self.user_map:
            self.user_map[followeeId] = User(followeeId)
        self.user_map[followerId].follow(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followerId in self.user_map:
            self.user_map[followerId].unfollow(followeeId)


class User:
    def __init__(self, userId: int):
        self.userId = userId
        self.followed = set()
        self.head = None
        self.follow(userId)

    def follow(self, followeeId: int):
        self.followed.add(followeeId)

    def unfollow(self, followeeId: int):
        if self.userId != followeeId:
            self.followed.discard(followeeId)

    def postTweet(self, tweetId: int, ):
        tweet = Tweet(tweetId, Twitter.timestamp)
        Twitter.timestamp += 1
        tweet.next = self.head
        self.head = tweet


class Tweet:
    def __init__(self, tweetId: int, timestamp: int):
        self.tweetId = tweetId
        self.timestamp = timestamp
        self.next = None
