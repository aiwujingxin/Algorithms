package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/28 20:17
 */
public class LeetCode546 {

    int[][][] memo;
    int[] boxes;

    public int removeBoxe(int[] boxes) {
        int n = boxes.length;
        this.boxes = boxes;
        this.memo = new int[n][n][n];
        return dfs(0, n - 1, 0);
    }

    private int dfs(int i, int j, int k) {
        if (i > j) return 0;
        if (memo[i][j][k] != 0) return memo[i][j][k];
        int originalI = i, originalK = k;
        // 将 [i, ..., i+t] 全部和 boxes[i] 一样的向右延伸
        while (i + 1 <= j && boxes[i] == boxes[i + 1]) {
            i++;
            k++;
        }
        // 先将前面连续的 (k+1) 个 boxes[i] 全部移除
        int res = (k + 1) * (k + 1) + dfs(i + 1, j, 0);
        // 尝试将 boxes[m] == boxes[i] 的点合并处理
        for (int m = i + 1; m <= j; m++) {
            if (boxes[m] == boxes[i]) {
                // 中间 [i+1, m-1] 要全部移除，才能合并 i 和 m
                int temp = dfs(i + 1, m - 1, 0) + dfs(m, j, k + 1);
                res = Math.max(res, temp);
            }
        }
        return memo[originalI][j][originalK] = res;
    }

    //dp[i][j][k]：区间 [i, j] 内，左侧和 boxes[i] 连续相同颜色盒子数量为 k 时的最大分数。
    public int removeBoxes_dp(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        // 初始化长度为1的区间
        for (int i = 0; i < n; i++) {
            for (int k = 0; k <= i; k++) {
                dp[i][i][k] = (k + 1) * (k + 1);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int k = 0; k <= i; k++) {
                    // 先移除左侧连续 k+1 个 boxes[i]，加上区间 [i+1, j] 不带连续的最大分数
                    int res = (k + 1) * (k + 1) + dp[i + 1][j][0];
                    // 尝试和区间后面相同颜色盒子合并，获得更高分数
                    for (int m = i + 1; m <= j; m++) {
                        if (boxes[m] == boxes[i]) {
                            int tmp = dp[i + 1][m - 1][0] + dp[m][j][k + 1];
                            if (tmp > res) {
                                res = tmp;
                            }
                        }
                    }
                    dp[i][j][k] = res;
                }
            }
        }
        return dp[0][n - 1][0];
    }
}
