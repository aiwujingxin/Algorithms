package leetcode.plan.algorithm.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/7 21:41
 */
public class LeetCode283 {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }
        int cur = 0;
        int count = 0;
        while (cur < nums.length - count) {

            while (cur < nums.length - count && nums[cur] != 0) {
                cur++;
            }

            if (cur == nums.length) {
                break;
            }

            int t = cur;
            while (t + 1 <= nums.length - 1 - count) {
                nums[t] = nums[t + 1];
                t++;
            }
            nums[t] = 0;
            count++;
        }
    }
}
