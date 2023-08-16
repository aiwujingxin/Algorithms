package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/29 15:36
 */
public class LeetCode268_bit {

    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; ++i) {
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }
}
