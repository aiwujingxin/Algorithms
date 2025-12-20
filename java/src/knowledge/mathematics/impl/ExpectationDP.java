package knowledge.mathematics.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 12/21/25 02:09
 * @description 数学期望 DP 示例
 */
public class ExpectationDP {

    /**
     * 问题：一个 n 面骰子，集齐 m (m <= n) 种不同面孔的期望投掷次数。
     * @param n 骰子总面数
     * @param m 目标收集的面数
     * @return 期望次数
     */
    public double collectCards(int n, int m) {
        if (m == 0) return 0.0;
        if (m > n) return Double.POSITIVE_INFINITY; // 不可能完成
        // dp[i] 表示：已经拥有 i 种卡片，还需要掷多少次才能集齐 m 种
        double[] dp = new double[m + 1];
        // 边界条件：已经拥有 m 种，还需要 0 次
        dp[m] = 0.0;
        // 从 m-1 倒推到 0
        for (int i = m - 1; i >= 0; i--) {
            // 当前有 i 种，下一次投掷：
            // 1. 投到已有的 i 种之一：概率 p1 = i / n
            // 2. 投到新的 n-i 种之一：概率 p2 = (n - i) / n
            // 状态转移方程：
            // dp[i] = 1 + (i/n) * dp[i] + ((n-i)/n) * dp[i+1]
            // 整理得：
            // dp[i] * (1 - i/n) = 1 + ((n-i)/n) * dp[i+1]
            // dp[i] * ((n-i)/n) = 1 + ((n-i)/n) * dp[i+1]
            // dp[i] = n/(n-i) + dp[i+1]

            double p_new = (double) (n - i) / n;
            dp[i] = (1.0 + p_new * dp[i + 1]) / p_new; // 这是从原始定义推导
            // 或者直接用整理后的公式：
            // dp[i] = (double) n / (n - i) + dp[i + 1];
        }
        // 返回从 0 种开始的期望次数
        return dp[0];
    }
}
