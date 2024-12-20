package com.dsa.leetcode.labuladong.queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class P355_DesignTwitter {
    class Twitter {
        int timestamp;
        Map<Integer, User> userMap;

        public Twitter() {
            timestamp = 1;
            userMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            if (!userMap.containsKey(userId)) {
                userMap.put(userId, new User(userId));
            }
            userMap.get(userId).postTweet(tweetId);
        }

        public List<Integer> getNewsFeed(int userId) {
            if (!userMap.containsKey(userId)) {
                return new ArrayList<>();
            }
            User user = userMap.get(userId);
            PriorityQueue<Tweet> heap = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);
            for (Integer id : user.followed) {
                User followee = userMap.get(id);
                if (followee.head != null) {
                    heap.add(followee.head);
                }
            }

            List<Integer> res = new LinkedList<>();
            while (!heap.isEmpty() && res.size() < 10) {
                Tweet poll = heap.poll();
                res.add(poll.tweetId);
                if (poll.next != null) {
                    heap.add(poll.next);
                }
            }
            return res;
        }

        public void follow(int followerId, int followeeId) {
            if (!userMap.containsKey(followerId)) {
                userMap.put(followerId, new User(followerId));
            }
            if (!userMap.containsKey(followeeId)) {
                userMap.put(followeeId, new User(followeeId));
            }
            userMap.get(followerId).follow(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (userMap.containsKey(followerId)) {
                userMap.get(followerId).unfollow(followeeId);
            }
        }

        // user
        class User {
            int userId;
            // store followed
            Set<Integer> followed;
            Tweet head;

            public User(int userId) {
                this.userId = userId;
                followed = new HashSet<>();
                head = null;
                // must follow oneself
                follow(userId);
            }

            public void postTweet(int tweetId) {
                Tweet tweet = new Tweet(tweetId, timestamp);
                timestamp++;
                tweet.next = head;
                head = tweet;
            }

            public void follow(int followeeId) {
                followed.add(followeeId);
            }

            public void unfollow(int followeeId) {
                // can't unfollow oneself
                if (userId != followeeId) {
                    followed.remove(followeeId);
                }
            }

        }

        // // Tweet
        class Tweet {
            int tweetId;
            int timestamp;
            Tweet next;

            public Tweet(int tweetId, int timestamp) {
                this.tweetId = tweetId;
                this.timestamp = timestamp;
            }
        }
    }
}
