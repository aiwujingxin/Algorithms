package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/7/30 16:19
 */
public class LeetCode813 {

    double largestSumOfAverages(int[] nums, int K) {
        /*
            状态：数组A的每个元素，分割为K个相邻的数组
            选择：枚举所有分割k的可能性，分割成k份 == 分割成k-1份+最后一份
        */
        int n = nums.length;
        double[] presum = new double[n + 1];
        double[][] dp = new double[n + 1][K + 1];
        for (int i = 1; i <= n; ++i) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; ++i) {
            dp[i][1] = presum[i] / i;
            for (int k = 2; k <= K && k <= i; ++k) {
                for (int j = 1; j < i; ++j) {
                    dp[i][k] = Math.max(dp[i][k], dp[j][k - 1] + (presum[i] - presum[j]) / (i - j));
                }
            }
        }
        return dp[n][K];
    }
}
