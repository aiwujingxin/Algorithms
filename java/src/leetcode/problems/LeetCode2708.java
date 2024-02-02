package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/2 11:49
 */
public class LeetCode2708 {

    long res = Long.MIN_VALUE;

    public long maxStrength(int[] nums) {
        backtrack(nums, 0, 1);
        return res;
    }

    private void backtrack(int[] nums, int index, long prod) {
        if (index > 0) {
            res = Math.max(prod, res);
        }
        for (int i = index; i < nums.length; i++) {
            if (nums[i] == 0) {
                backtrack(nums, i + 1, 0);
            } else {
                prod = prod * nums[i];
                backtrack(nums, i + 1, prod);
                prod = prod / nums[i];
            }
        }
    }
}
