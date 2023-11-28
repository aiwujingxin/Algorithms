package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/28 16:47
 */
public class LeetCode413 {

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int dp = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp++;
            } else {
                dp = 0;
            }
            res += dp;
        }
        return res;
    }
}
