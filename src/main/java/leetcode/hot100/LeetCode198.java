package leetcode.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/4 16:51
 */
public class LeetCode198 {

    public static void main(String[] args) {
        System.out.println(new LeetCode198().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new LeetCode198().rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(new LeetCode198().rob(new int[]{2, 1, 1, 2}));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //[a,b]
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        int max = 0;
        //init
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
