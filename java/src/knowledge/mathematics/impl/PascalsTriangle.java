package knowledge.mathematics.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 12/21/25 02:06
 * @description 杨辉三角形和二项式系数
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
