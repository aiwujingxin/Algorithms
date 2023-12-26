package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/12 13:38
 */
public class LeetCode259 {

    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int right = rightBound(nums, j + 1, nums.length - 1, target - nums[i] - nums[j]);
                if (right != -1) {
                    res += right - j;
                }
            }
        }
        return res;
    }

    private int rightBound(int[] nums, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (nums[left] >= target) {
            return -1;
        }
        return left;
    }
}
