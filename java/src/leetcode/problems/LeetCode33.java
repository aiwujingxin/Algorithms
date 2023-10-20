package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/20 11:24
 */
public class LeetCode33 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= target) {
                if (nums[left] <= nums[mid] && nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[right] >= nums[mid] && nums[mid] >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
