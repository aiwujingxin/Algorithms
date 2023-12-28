package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/28 20:17
 */
public class LeetCode546 {

    int[][] memo;
    int[] boxes;

    int n;

    public int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length == 0) {
            return 0;
        }
        memo = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }
        this.n = boxes.length;
        return dfs(0, n + 1);
    }

    private int dfs(int i, int j) {
        if (i >= j - 1) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        for (int k = i + 1; k < j; k++) {
            int left = dfs(i, k);
            int right = dfs(k, j);
            int sum;
            if (k - 1 >= 0 && k + 1 < boxes.length && boxes[k - 1] == boxes[k + 1]) {
                sum = (right - left + 1) * (right - left + 1);
            } else {
                sum = boxes[i] + left + right;
            }
            memo[i][j] = Math.max(memo[i][j], sum);
        }
        return memo[i][j];
    }
}
