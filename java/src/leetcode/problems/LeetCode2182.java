package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 9/2/25 13:44
 */
public class LeetCode2182 {

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                pq.offer(new int[]{i, count[i]});
            }
        }
        StringBuilder res = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            char currentChar = (char) (current[0] + 'a');
            int c = current[1];
            if (res.isEmpty() || res.charAt(res.length() - 1) != currentChar) {
                int addCount = Math.min(c, repeatLimit);
                res.append(String.valueOf(currentChar).repeat(addCount));
                c -= addCount;
                if (c > 0) {
                    pq.offer(new int[]{current[0], c});
                }
            } else {
                if (pq.isEmpty()) {
                    break;
                }
                int[] next = pq.poll();
                char nextChar = (char) (next[0] + 'a');
                int nextCount = next[1];
                res.append(nextChar);
                nextCount--;
                if (nextCount > 0) {
                    pq.offer(new int[]{next[0], nextCount});
                }
                pq.offer(new int[]{current[0], c});
            }
        }
        return res.toString();
    }
}
