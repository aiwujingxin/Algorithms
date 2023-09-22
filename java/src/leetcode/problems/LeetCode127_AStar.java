package leetcode.problems;


import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/5 22:19
 */
public class LeetCode127_AStar {

    //https://leetcode.cn/problems/word-ladder/solution/gong-shui-san-xie-ru-he-shi-yong-shuang-magjd/

    String s, e;
    Set<String> set = new HashSet<>();

    public int ladderLength(String beginWord, String endWord, List<String> ws) {
        s = beginWord;
        e = endWord;
        set.addAll(ws);
        if (!set.contains(e)) {
            return 0;
        }

        int ans = astar();
        return ans == -1 ? 0 : ans + 1;
    }

    int astar() {
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        Map<String, Integer> dist = new HashMap<>();
        dist.put(s, 0);
        q.add(new Node(s, f(s)));

        while (!q.isEmpty()) {
            Node poll = q.poll();
            String str = poll.str;
            int distance = dist.get(str);
            if (str.equals(e)) {
                break;
            }
            int n = str.length();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 26; j++) {
                    String sub = str.substring(0, i) + (char) ('a' + j) + str.substring(i + 1);
                    if (!set.contains(sub)) {
                        continue;
                    }
                    if (!dist.containsKey(sub) || distance + 1 < dist.get(sub)) {
                        dist.put(sub, distance + 1);
                        q.add(new Node(sub, dist.get(sub) + f(sub)));
                    }
                }
            }
        }
        return dist.getOrDefault(e, -1);
    }

    // 单词距离
    int f(String str) {
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            ans += str.charAt(i) == e.charAt(i) ? 0 : 1;
        }
        return ans;
    }

    static class Node {
        String str;
        int val;

        Node(String _str, int _val) {
            str = _str;
            val = _val;
        }
    }
}
