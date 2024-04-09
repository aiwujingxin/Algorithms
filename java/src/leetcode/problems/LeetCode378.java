package leetcode.problems;

import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/21 23:59
 */
public class LeetCode378 {

    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            return o1[2] - o2[2];
        });
        for (int i = 0; i < m; i++) {
            queue.add(new int[]{i, 0, matrix[i][0]});
        }
        for (int j = 1; j < k; j++) {
            int[] node = queue.poll();
            int col = node[1];
            if (col < n - 1) {
                queue.add(new int[]{node[0], col + 1, matrix[node[0]][col + 1]});
            }
        }
        return queue.peek()[2];
    }

    public int kthSmallest_bs(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0];
        int r = matrix[n - 1][n - 1];
        while (l < r) {
            int mid = r + l >> 1;
            if (check(matrix, mid, k, n)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int left = n - 1;
        int right = 0;
        int cnt = 0;
        while (left >= 0 && right < n) {
            if (matrix[left][right] <= mid) {
                cnt += left + 1;
                right++;
            } else {
                left--;
            }
        }
        return cnt >= k;
    }
}
