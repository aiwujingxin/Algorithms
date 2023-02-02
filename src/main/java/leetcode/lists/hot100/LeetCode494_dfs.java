package leetcode.lists.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/5 22:00
 */
public class LeetCode494_dfs {

    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        helper(nums, target, 0, 0);

        return count;
    }

    public void helper(int[] nums, int target, int sum, int index) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            helper(nums, target, sum + nums[index], index + 1);
            helper(nums, target, sum - nums[index], index + 1);
        }
    }
}
