package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/6 23:15
 * 多路归并
 */
public class LeetCode786_Q_v2 {
    //起始将 n−1 个序列的头部元素放入堆中，然后重复k 次操作得到第 k 小的值
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            double i1 = arr[a[0]] * 1.0 / arr[a[1]], i2 = arr[b[0]] * 1.0 / arr[b[1]];
            return Double.compare(i1, i2);
        });
        for (int i = 1; i < n; i++) {
            q.add(new int[]{0, i});
        }
        while (k-- > 1) {
            int[] poll = q.poll();
            int i = poll[0], j = poll[1];
            if (i + 1 < j) {
                q.add(new int[]{i + 1, j});
            }
        }
        int[] poll = q.poll();
        return new int[]{arr[poll[0]], arr[poll[1]]};
    }
}
