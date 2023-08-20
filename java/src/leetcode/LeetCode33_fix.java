package leetcode;

/**
 * @author jingxinwu
 * @date 2022-02-17 3:41 PM
 */
public class LeetCode33_fix {

    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        //fix 退出条件
        while (left + 1 < right) {

            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > nums[left]) {
                //fix = 号
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //fix = 号
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;

                } else {
                    right = mid - 1;
                }
            }
        }
        //fix
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }
}
