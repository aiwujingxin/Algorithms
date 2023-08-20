package leetcode;

/**
 * @author jingxinwu
 * @date 2021-06-23 1:36 上午
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

            int cur = i + nums[i];
            max = Math.max(cur, max);
        }
        return max >= nums.length - 1;
    }

}
