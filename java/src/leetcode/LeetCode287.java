package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/19 20:36
 */
public class LeetCode287 {
    public int findDuplicate(int[] nums) {
        if (nums == null) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] < 0) {
                return num - 1;
            }
            nums[num - 1] = -nums[num - 1];
        }
        return -1;

    }
}