package leetcode.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 6/10/26 00:54
 */
public class LeetCode2462 {

    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> pre = new PriorityQueue<>((Comparator.comparingInt(o -> o)));
        PriorityQueue<Integer> last = new PriorityQueue<>((Comparator.comparingInt(o -> o)));
        int i = 0;
        int j = n - 1;
        int cnt = 0;
        long ans = 0;
        while (cnt < k) {
            while (pre.size() < candidates && i <= j) {
                pre.add(costs[i]);
                i++;
            }
            while (last.size() < candidates && i <= j) {
                last.add(costs[j]);
                j--;
            }
            Integer p = pre.isEmpty() ? null : pre.peek();
            Integer l = last.isEmpty() ? null : last.peek();
            if (p == null && l == null) {
                break;
            }
            if (p == null) {
                ans += last.poll();
            } else if (l == null || p <= l) {
                ans += pre.poll();
            } else {
                ans += last.poll();
            }
            cnt++;
        }
        return ans;
    }
}
