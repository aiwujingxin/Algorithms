package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/3 02:00
 */
public class LeetCode752_AStar {

    //https://leetcode.cn/problems/open-the-lock/solution/gong-shui-san-xie-yi-ti-shuang-jie-shuan-wyr9/

    String s, t;
    Set<String> set = new HashSet<>();

    public int openLock(String[] ds, String _t) {
        s = "0000";
        t = _t;
        if (s.equals(t)) {
            return 0;
        }

        Collections.addAll(set, ds);
        if (set.contains(s)) {
            return -1;
        }

        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        Map<String, Node> map = new HashMap<>();
        Node root = new Node(s, f(s), 0);
        q.add(root);
        map.put(s, root);
        while (!q.isEmpty()) {
            Node poll = q.poll();
            char[] pcs = poll.str.toCharArray();
            int step = poll.step;
            if (poll.str.equals(t)) {

                return step;
            }
            for (int i = 0; i < 4; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (j == 0) {
                        continue;
                    }

                    int cur = pcs[i] - '0';
                    int next = (cur + j) % 10;
                    if (next == -1) next = 9;

                    char[] clone = pcs.clone();
                    clone[i] = (char) (next + '0');
                    String str = String.valueOf(clone);

                    if (set.contains(str)) {
                        continue;
                    }

                    // 如果 str 还没搜索过，或者 str 的「最短距离」被更新，则入队
                    if (!map.containsKey(str) || map.get(str).step > step + 1) {
                        Node node = new Node(str, step + 1 + f(str), step + 1);
                        map.put(str, node);
                        q.add(node);
                    }
                }
            }
        }
        return -1;
    }

    int f(String str) {
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            int cur = str.charAt(i) - '0', target = t.charAt(i) - '0';
            int a = Math.min(cur, target), b = Math.max(cur, target);
            // 在「正向转」和「反向转」之间取 min
            int min = Math.min(b - a, a + 10 - b);
            ans += min;
        }
        return ans;
    }

    static class Node {
        String str;
        int val, step;

        /**
         * str : 对应字符串
         * val : 估值（与目标字符串 target 的最小转换成本）
         * step: 对应字符串是经过多少步转换而来
         */
        Node(String _str, int _val, int _step) {
            str = _str;
            val = _val;
            step = _step;
        }
    }
}
