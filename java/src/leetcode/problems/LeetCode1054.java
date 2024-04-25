package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/26 00:53
 */
public class LeetCode1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : barcodes) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            if (pq.size() < 2 && pq.peek()[1] > 1) {
                return new int[]{};
            }
            List<int[]> temp = new ArrayList<>();
            int len = pq.size();
            for (int i = 0; i < Math.min(2, len); i++) {
                int[] entry = pq.poll();
                res.add(entry[0]);
                entry[1]--;
                if (entry[1] != 0) {
                    temp.add(entry);
                }
            }
            pq.addAll(temp);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
