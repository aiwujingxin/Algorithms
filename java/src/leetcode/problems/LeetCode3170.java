package leetcode.problems;

import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 7/5/26 16:00
 */
public class LeetCode3170 {

    public String clearStars(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        boolean[] deleted = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });
        for (int i = 0; i < n; i++) {
            if (chars[i] == '*') {
                deleted[i] = true;
                if (!pq.isEmpty()) {
                    int[] min = pq.poll();
                    deleted[min[1]] = true;
                }
            } else {
                pq.offer(new int[]{chars[i] - 'a', i});
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!deleted[i]) {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
