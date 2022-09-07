package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-12-11 11:17 下午
 */
public class LeetCode136 {


    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }

        return res;
    }
}
