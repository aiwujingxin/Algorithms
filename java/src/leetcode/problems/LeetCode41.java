package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/19 17:12
 */
public class LeetCode41 {

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (index < n) {
                nums[index] = -Math.abs(nums[index]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
