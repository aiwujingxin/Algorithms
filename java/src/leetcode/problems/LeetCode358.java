package leetcode.problems;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

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
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> cnt[o2] - cnt[o1]);
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0) {
                pq.add(i);
            }
        }
        // 2.开始进行贪心操作,就是我们每次操作都要选择次数最多的
        StringBuilder sb = new StringBuilder();
        Queue<Integer> temp = new LinkedList<>();
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            temp.add(cur);
            cnt[cur]--;
            sb.append((char) ('a' + cur));
            if (temp.size() >= k) {
                int mem = temp.poll();
                if (cnt[mem] > 0) {
                    pq.add(mem);
                }
            }
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }
}
