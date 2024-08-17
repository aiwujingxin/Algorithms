package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 12:30
 */
public class LeetCode300 {

    public int lengthOfLIS(int[] nums) {
        int len = 0;
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            len = Math.max(len, dp[i]);
        }
        return len;
    }
}
