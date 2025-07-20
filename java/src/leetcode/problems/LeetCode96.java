package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/4 16:32
 * @description 卡特兰数 区间DP
 */
public class LeetCode96 {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
