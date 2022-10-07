package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/24 20:09
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
