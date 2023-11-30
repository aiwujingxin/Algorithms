package leetcode.problems;

import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/21 23:59
 * @description 多路排序
 */
public class LeetCode378 {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        for (int i = 0; i < matrix.length; i++) {
            pq.add(new int[]{matrix[i][0], i, 0});
        }

        while (!pq.isEmpty() && k-- > 0) {
            int[] curr = pq.poll();
            if (k == 0) {
                return curr[0];
            }

            if (curr[2] == matrix[0].length - 1) {
                continue;
            }

            pq.offer(new int[]{matrix[curr[1]][curr[2] + 1], curr[1], curr[2] + 1});
        }

        return -1;
    }

    public int kthSmallest_bs(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int cnt = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                cnt += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return cnt >= k;
    }
}
