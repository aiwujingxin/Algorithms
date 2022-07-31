package LeetCode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/7/30 16:19
 */
public class LeetCode813_dp {

    double largestSumOfAverages(int[] nums, int K) {
        /*
            状态：数组A的每个元素，分割为K个相邻的数组
            选择：枚举所有分割k的可能性，分割成k份 == 分割成k-1份+最后一份
        */

        double[] sum = new double[nums.length + 1];
        double[][] dp = new double[nums.length + 1][K + 1];
        for (int i = 1; i <= nums.length; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= nums.length; ++i) {
            dp[i][1] = sum[i] / i;
            for (int k = 2; k <= K && k <= i; ++k) {
                for (int j = 1; j < i; ++j) {
                    dp[i][k] = Math.max(dp[i][k], dp[j][k - 1] + (sum[i] - sum[j]) / (i - j));
                }
            }
        }
        return dp[nums.length][K];
    }
}
