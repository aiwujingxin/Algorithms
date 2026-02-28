package knowledge.mathematics.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 12/21/25 02:06
 * @description 杨辉三角形和二项式系数
 * 杨辉三角的构建逻辑与 DP 的核心三要素完全一致：
 * 状态定义：dp[i][j] 表示第 i 行、第 j 列的数值。
 * 转移方程：dp[i][j] = dp[i-1][j-1] + dp[i-1][j], 每一个数等于左, 上两个数之和。
 * @see leetcode.problems.LeetCode118
 * @see leetcode.problems.LeetCode119
 */
public class PascalsTriangle {

    /**
     * 直接计算二项式系数 C(n, k)
     * 使用公式 C(n, k) = n! / (k! * (n-k)!) = (n * (n-1) * ... * (n-k+1)) / k!
     *
     * @param n 总数
     * @param k 选取的数量
     * @return C(n, k) 的值
     */
    public long binomialCoefficient(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        }
        // C(n, k) == C(n, n-k)，取较小的 k 计算可以提高效率
        if (k > n / 2) {
            k = n - k;
        }
        long result = 1;
        // 计算 (n * (n-1) * ... * (n-k+1)) / k!
        for (int i = 1; i <= k; i++) {
            result = result * (n - i + 1) / i;
        }
        return result;
    }
}
