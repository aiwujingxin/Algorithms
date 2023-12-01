package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/28 16:47
 */
public class LeetCode413 {

    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }
        // dp[i] 表示以：nums[i] 结尾的、且长度大于等于 3 的连续等差数列的个数
        int[] dp = new int[len];
        int res = 0;
        // 从下标 2 开始，才有可能构成长度至少大于等于 3 的等差数列
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                res += dp[i];
            }
        }
        return res;
    }
}
