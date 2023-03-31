package leetcode.lists.hot200;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/16 23:43
 */
public class LeetCode487 {

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][2];
        if (nums[0] == 1) {
            dp[0][0] = 1;
        } else {
            dp[0][1] = 1;
        }
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                dp[i][0] = 0;
                dp[i][1] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] + 1;
            }
            max = Math.max(Math.max(max, dp[i][0]), dp[i][1]);
        }
        return max;
    }
}
