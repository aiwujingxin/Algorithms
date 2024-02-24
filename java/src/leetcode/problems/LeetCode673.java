package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2024-02-25 10:15 PM
 */
public class LeetCode673 {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        int[] g = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = g[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        g[i] = g[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        //可能找到若干个j, i 都可以接在后面, 则都需要算进去
                        g[i] += g[j];
                    }
                }
            }
            len = Math.max(len, dp[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == len) {
                res += g[i];
            }
        }
        return res;
    }
}
