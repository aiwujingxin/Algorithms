package leetCode.problems;

/**
 * @author jingxinwu
 * @date 2021-12-13 12:25 AM
 */
public class LeetCode413 {


    public int numberOfArithmeticSlices(int[] nums) {

        if (nums == null || nums.length <= 2) {
            return 0;
        }

        int dp = 0;
        int res = 0;

        for (int i = 3; i <= nums.length; i++) {
            if (nums[i - 1] - nums[i - 2] == nums[i - 2] - nums[i - 3]) {
                dp++;
            } else {
                dp = 0;
            }
            res += dp;

        }
        return res;
    }
}
