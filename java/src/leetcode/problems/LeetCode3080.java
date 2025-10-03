package leetcode.problems;


import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 7/22/25 22:24
 */
public class LeetCode3080 {

    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int n = queries.length;
        long[] ans = new long[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            pq.add(new int[]{nums[i], i});
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int[] query = queries[i];
            int index = query[0];
            int k = query[1];
            if (!set.contains(index)) {
                sum -= nums[index];
                set.add(index);
            }
            int cnt = 0;
            while (!pq.isEmpty() && cnt < k) {
                int[] node = pq.poll();
                if (set.contains(node[1])) {
                    continue;
                }
                sum -= node[0];
                set.add(node[1]);
                cnt++;
            }
            ans[i] = sum;
        }
        return ans;
    }
}
