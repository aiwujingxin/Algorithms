package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/18 22:54
 */
public class LeetCode136 {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }
}