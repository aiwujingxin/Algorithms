package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/20 16:20
 */
public class LeetCode55 {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < i) {
                return false;
            }
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }
}
