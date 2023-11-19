package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/18 15:40
 * @description 多路排序
 */
public class LeetCode355 {

    class Twitter {

        private int timestamp = 0;

        public Twitter() {

        }

        //  userId : User
        private final HashMap<Integer, User> userMap = new HashMap<>();

        public void postTweet(int userId, int tweetId) {
            if (!userMap.containsKey(userId)) {
                userMap.put(userId, new User(userId));
            }
            User u = userMap.get(userId);
            u.post(tweetId);
        }

        public void follow(int followerId, int followeeId) {
            if (!userMap.containsKey(followerId)) {
                User u = new User(followerId);
                userMap.put(followerId, u);
            }
            userMap.get(followerId).follow(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (userMap.containsKey(followerId)) {
                userMap.get(followerId).unfollow(followeeId);
            }
        }


        public List<Integer> getNewsFeed(int userId) {
            List<Integer> res = new ArrayList<>();
            if (!userMap.containsKey(userId)) {
                return res;
            }
            // 关注列表的用户 Id
            Set<Integer> users = userMap.get(userId).followed;
            // 自动通过 time 属性从大到小排序，容量为 users 的大小
            PriorityQueue<Tweet> pq = new PriorityQueue<>(users.size(), (a, b) -> (b.time - a.time));

            // 先将所有链表头节点插入优先级队列
            for (int id : users) {
                if (userMap.get(id) == null) {
                    continue;
                }
                Tweet twt = userMap.get(id).head;
                if (twt == null) {
                    continue;
                }
                pq.add(twt);
            }

            while (!pq.isEmpty()) {
                // 最多返回 10 条就够了
                if (res.size() == 10) {
                    break;
                }
                // 弹出 time 值最大的（最近发表的）
                Tweet twt = pq.poll();
                res.add(twt.id);
                // 将下一篇 Tweet 插入进行排序
                if (twt.next != null) {
                    pq.add(twt.next);
                }
            }
            return res;
        }

        static class Tweet {
            private final int id;
            private final int time;
            private Tweet next;

            // 需要传入推文内容（id）和发文时间
            public Tweet(int id, int time) {
                this.id = id;
                this.time = time;
                this.next = null;
            }
        }

        class User {
            private final int id;
            public Set<Integer> followed;
            // 用户发表的推文链表头结点
            public Tweet head;

            public User(int userId) {
                followed = new HashSet<>();
                this.id = userId;
                this.head = null;
                // 关注一下自己
                follow(id);
            }

            public void follow(int userId) {
                followed.add(userId);
            }

            public void unfollow(int userId) {
                // 不可以取关自己
                if (userId != this.id) followed.remove(userId);
            }

            public void post(int tweetId) {
                Tweet twt = new Tweet(tweetId, timestamp);
                timestamp++;
                // 将新建的推文插入链表头
                // 越靠前的推文 time 值越大
                twt.next = head;
                head = twt;
            }
        }
    }
}
