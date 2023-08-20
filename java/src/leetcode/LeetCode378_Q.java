package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/4 23:22
 */
public class LeetCode378_Q {
    /*
     * [1, 5, 9],
     * [10,11,13],
     * [12,13,15]
     * */

    // 相当于归并排序
    // 用小根堆维护，以优化时间复杂度。
    public static void main(String[] args) {
        System.out.println(new LeetCode378_Q().kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
    }

    //https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/1524783/Java-or-Two-Solutions-or-Binary-Search-%2B-PriorityQueue
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || k <= 0) {
            return -1;
        }
        int n = matrix.length;
        if (k > n * n) {
            return -1;
        }
        if (k == 1) {
            return matrix[0][0];
        }
        if (k == n * n) {
            return matrix[n - 1][n - 1];
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]];
            }
        });

        for (int i = 0; i < Math.min(n, k); i++) {
            queue.offer(new int[]{i, 0});
        }
        while (k > 1) {
            int[] cur = queue.poll();
            if (cur[1] < n - 1) {
                cur[1]++;
                queue.offer(cur);
            }
            k--;
        }

        return matrix[queue.peek()[0]][queue.peek()[1]];
    }
}
