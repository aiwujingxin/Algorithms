package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/5 18:54
 */
public class LeetCode338 {

    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - (i & -i)] + 1;
        }
        return dp;
    }
}
