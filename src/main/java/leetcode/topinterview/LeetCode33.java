package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/21 23:57
 */
public class LeetCode33 {

    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[left]) {
                //fix
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (nums[right] >= target && nums[mid] < target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }

        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }
}
