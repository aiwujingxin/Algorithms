package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 8/18/25 23:09
 * @description 你有一个整数数组 nums。你只能将一个元素 nums[i] 替换为 nums[i] * nums[i]。
 * 返回替换后的最大子数组和。
 * 示例 1：
 * 输入：nums = [2,-1,-4,-3]
 * 输出：17
 * 解释：你可以把-4替换为16(-4*(-4))，使nums = [2,-1,16,-3]. 现在，最大子数组和为 2 + -1 + 16 = 17.
 * <p>
 * 示例 2：
 * 输入：nums = [1,-1,1,1,-1,-1,1]
 * 输出：4
 * 解释：你可以把第一个-1替换为1，使 nums = [1,1,1,1,-1,-1,1]. 现在，最大子数组和为 1 + 1 + 1 + 1 = 4.
 * 1 <= nums.length <= 10^5
 * -104 <= nums[i] <= 10^4
 */
public class LeetCode1746 {

    public int maxSumAfterOperation(int[] nums) {
        int f = 0, g = 0;
        int ans = Integer.MIN_VALUE;
        for (int x : nums) {
            int ff = Math.max(f, 0) + x;
            int gg = Math.max(Math.max(f, 0) + x * x, g + x);
            f = ff;
            g = gg;
            ans = Math.max(ans, Math.max(f, g));
        }
        return ans;
    }
}
