package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/5 23:30
 */
public class LeetCode268 {

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int has = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (index >= nums.length) {
                continue;
            }
            if (nums[index] == 0) {
                has = index;
            }
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0 && has != i) {
                return i;
            }
        }
        return nums.length;
    }

    public int missingNumber_bs(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
