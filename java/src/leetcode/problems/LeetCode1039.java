package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/12 22:41
 */
public class LeetCode1039 {

    private int[] values;
    private int[][] memo;

    public int minScoreTriangulation(int[] values) {
        this.values = values;
        int n = this.values.length;
        memo = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, n - 1);
    }

    private int dfs(int i, int j) {
        if (i + 1 == j) {// 只有两个点，无法组成三角形
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; ++k) { // 枚举顶点 k
            res = Math.min(res, dfs(i, k) + dfs(k, j) + values[i] * values[j] * values[k]);
        }
        return memo[i][j] = res;
    }
}
