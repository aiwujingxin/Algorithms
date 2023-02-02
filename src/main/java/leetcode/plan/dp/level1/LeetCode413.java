package leetcode.plan.dp.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/16 14:26
 */
public class LeetCode413 {

    //https://www.youtube.com/watch?v=DEqVRwxYt6U
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;// 前面已经构成的数组个数 加上 当前也能构成的数组
                res += dp[i];
            }
        }
        return res;
    }
}
