package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/20 11:19
 * @description 二分模板
 */
public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int leftIndex = findLeft(nums, target);
        int rightIndex = findRight(nums, target);
        if (nums[leftIndex] != target) {
            leftIndex = -1;
        }
        if (nums[rightIndex] != target) {
            rightIndex = -1;
        }
        return new int[]{leftIndex, rightIndex};
    }

    private int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
