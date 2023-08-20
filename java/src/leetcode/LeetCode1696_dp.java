package leetcode;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/5 01:09
 */
public class LeetCode1696_dp {

    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= Math.min(nums.length - 1, i + k); j++) {
                dp[j] = Math.max(dp[i] + nums[j], dp[j]);
                //所以dp[j] > dp[i]时
                //dp[j+1]...dp[i+k]必然由dp[j]或者更后面的更大dp值跳跃得到, 这时我们可以直接break。
                //剪枝
                if (dp[j] >= dp[i]) {
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }
}
