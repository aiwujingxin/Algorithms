package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/11/2123:05
 */
public class LeetCode373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.add(new int[]{nums1[i], nums2[0], 0});
        }
        while (!pq.isEmpty() && k-- > 0) {
            int[] node = pq.poll();
            res.add(Arrays.asList(node[0], node[1]));
            if (node[2] == nums2.length - 1) {
                continue;
            }
            pq.offer(new int[]{node[0], nums2[node[2] + 1], node[2] + 1});
        }
        return res;
    }
}
