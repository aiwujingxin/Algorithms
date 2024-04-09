package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 18:07
 */
public class LeetCode34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        return new int[]{leftBound(nums, target), rightBound(nums, target)};
    }

    private int leftBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        if (nums[l] != target) {
            return -1;
        }
        return l;
    }

    private int rightBound(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] > target) r = mid - 1;
            else l = mid;
        }
        if (nums[l] != target) {
            return -1;
        }
        return l;
    }
}
