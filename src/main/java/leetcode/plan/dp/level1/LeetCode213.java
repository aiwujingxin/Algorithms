package leetcode.plan.dp.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/7 16:51
 */
public class LeetCode213 {

    public static void main(String[] args) {
        System.out.println(new LeetCode213().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new LeetCode213().rob(new int[]{1, 2, 3}));
    }

    int[] dp;

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        dp = new int[nums.length];
        return Math.max(rob(nums, 1, nums.length - 1), rob(nums, 0, nums.length - 2));
    }

    public int rob(int[] nums, int start, int end) {
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }
}
