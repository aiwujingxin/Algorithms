package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/27 16:58
 */
public class LeetCode2585 {

    private static final int MOD = (int) 1e9 + 7;

    public int waysToReachTarget(int target, int[][] types) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int[] type : types) {
            int count = type[0], marks = type[1];
            for (int j = target; j > 0; j--) {
                for (int k = 1; k <= Math.min(count, j / marks); k++) {
                    dp[j] = (dp[j] + dp[j - k * marks]) % MOD;
                }
            }
        }
        return dp[target];
    }
}
