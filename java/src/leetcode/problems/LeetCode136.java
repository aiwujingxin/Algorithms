package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/29 17:36
 */
public class LeetCode136 {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
