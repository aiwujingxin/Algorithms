package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/26 11:37
 */
public class LeetCode81 {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return nums[0] == target;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else {
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

        }
        return false;
    }
}
