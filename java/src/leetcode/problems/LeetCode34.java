package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 18:07
 */
public class LeetCode34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        return new int[]{findL(nums, target), findR(nums, target)};
    }

    private int findL(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        return nums[l] == target ? l : -1;
    }

    private int findR(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] > target) r = mid - 1;
            else l = mid;
        }
        return nums[l] == target ? l : -1;
    }
}
