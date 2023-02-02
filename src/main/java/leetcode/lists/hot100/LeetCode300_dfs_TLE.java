package leetcode.lists.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 02:06
 */
public class LeetCode300_dfs_TLE {

    public int lengthOfLIS(int[] nums) {
        return helper(nums, 0, -1);
    }

    public int helper(int[] nums, int ind, int prev) {
        if (ind == nums.length) {
            return 0;
        }

        int op1 = helper(nums, ind + 1, prev);
        int op2 = 0;
        if (prev == -1 || nums[prev] < nums[ind]) {
            op2 = 1 + helper(nums, ind + 1, ind);
        }
        return Math.max(op1, op2);
    }
}
