package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/17 11:31
 */
public class LeetCode136 {

    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
