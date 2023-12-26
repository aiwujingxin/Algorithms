package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 12:30
 */
public class LeetCode300 {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int t = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    t = Math.max(t, dp[j]);
                }
            }
            dp[i] = t + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
