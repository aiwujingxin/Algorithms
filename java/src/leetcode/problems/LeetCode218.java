package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 17:56
 */
public class LeetCode218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> list = new ArrayList<>();
        for (int[] building : buildings) {
            list.add(new int[]{building[0], building[2]});
            list.add(new int[]{building[1], -building[2]});
        }
        list.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        for (int[] it : list) {
            int top = pq.peek();
            if (it[1] >= 0) {
                pq.add(it[1]);
            } else {
                pq.remove(-it[1]);
            }
            if (top != pq.peek()) {
                ArrayList<Integer> curr = new ArrayList<>();
                curr.add(it[0]);
                curr.add(pq.peek());
                ans.add(curr);
            }
        }
        return ans;
    }
}
