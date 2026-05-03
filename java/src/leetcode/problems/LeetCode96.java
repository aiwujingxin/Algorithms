package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/4 16:32
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

    class Solution {
        public int numTrees(int n) {
            long ans = 1; // 对应 C_0 = 1
            for (int i = 1; i <= n; i++) {
                // 直接套用卡特兰数递推公式：C_i = C_{i-1} * (4i - 2) / (i + 1)
                ans = ans * (4L * i - 2) / (i + 1);
            }
            return (int) ans;
        }
    }
}
