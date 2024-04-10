package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/10 22:32
 */
public class LeetCode55 {

    public boolean canJump(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
