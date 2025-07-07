package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 7/6/25 13:19
 * @description 分类讨论方式
 * 默认加一 + 合并
 * 区间分割枚举 k
 * 从左端首字符分类
 */
public class LeetCode664 {

    // 将 i 单拎出来分析
    public int strangePrinter_i(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = 1 + dp[i + 1][j]; // 特殊处理一下
                for (int k = i + 1; k <= j; k++) {
                    if (s.charAt(k) == s.charAt(i)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + (k + 1 > j ? 0 : dp[k + 1][j]));
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    // 将 j 单拎出来分析
    public int strangePrinter_j(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + 1;
                for (int k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j - 1]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    // 将 i 和 j 单拎出来分析
    public int strangePrinter_ij(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i][j - 1];
                } else {
                    int minn = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        minn = Math.min(minn, f[i][k] + f[k + 1][j]);
                    }
                    f[i][j] = minn;
                }
            }
        }
        return f[0][n - 1];
    }
}
