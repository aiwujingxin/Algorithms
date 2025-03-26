package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/25 15:04
 */
public class LeetCode283 {

    public void moveZeroes(int[] nums) {
        int i0 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int t = nums[i];
                nums[i] = nums[i0];
                nums[i0] = t;
                i0++;
            }
        }
    }
}
