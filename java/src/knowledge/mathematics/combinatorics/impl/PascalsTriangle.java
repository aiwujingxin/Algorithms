package knowledge.mathematics.combinatorics.impl;

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
     * 构建前 numRows 行杨辉三角，triangle[i] 是第 i 行 (长度 i+1)。
     */
    public static long[][] generate(int numRows) {
        long[][] triangle = new long[numRows][];
        for (int i = 0; i < numRows; i++) {
            triangle[i] = new long[i + 1];
            triangle[i][0] = triangle[i][i] = 1;
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
        return triangle;
    }

    /**
     * 递推构建 C(n,k) 全表，table[i][j]=C(i,j) 对 mod 取模。
     * 预处理 O(maxN^2)，之后 O(1) 查询任意组合数。
     */
    public static long[][] binomialTable(int maxN, long mod) {
        long[][] table = new long[maxN + 1][maxN + 1];
        for (int i = 0; i <= maxN; i++) {
            table[i][0] = 1 % mod;
            for (int j = 1; j <= i; j++) {
                table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % mod;
            }
        }
        return table;
    }

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
