package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/17 00:06
 */
public class LeetCode55 {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
