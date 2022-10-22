package leetplan.dp.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/22 10:57
 */
public class LeetCode300 {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int t = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    t = Math.max(t, dp[j]);
                }
            }
            dp[i] = t + 1;
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
