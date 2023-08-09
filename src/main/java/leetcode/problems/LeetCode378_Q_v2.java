package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/4 23:59
 */
public class LeetCode378_Q_v2 {

    //https://www.jiakaobo.com/leetcode/378.%20Kth%20Smallest%20Element%20in%20a%20Sorted%20Matrix.html

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
}