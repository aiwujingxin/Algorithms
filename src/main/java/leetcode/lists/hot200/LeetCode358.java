package leetcode.lists.hot200;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/23 19:04
 */
public class LeetCode358 {
    public String rearrangeString(String s, int k) {
        if (k == 0) {
            return s;
        }
        // 1.字符类型计数
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        // 2.开始进行贪心操作,就是我们每次操作都要选择次数最多的
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> cnt[o2] - cnt[o1]);
        StringBuilder ans = new StringBuilder();
        Queue<Integer> temp = new LinkedList<>();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0) {
                heap.add(i);
            }

        }
        while (!heap.isEmpty()) {
            int curr = heap.poll();
            temp.add(curr);
            cnt[curr]--;
            ans.append((char) ('a' + curr));
            if (temp.size() >= k) {
                int mem = temp.poll();
                if (cnt[mem] > 0) {
                    heap.offer(mem);
                }
            }
        }
        return ans.length() == s.length() ? ans.toString() : "";
    }
}
