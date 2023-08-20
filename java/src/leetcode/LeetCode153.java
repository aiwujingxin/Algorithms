package leetcode;

/**
 * @author jingxinwu
 * @date 2021-08-04 11:58 下午
 */
public class LeetCode153 {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] < nums[right]) {
                right = pivot;
            } else {
                left = pivot + 1;
            }
        }
        return nums[left];
    }


    public int findMin2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                right = mid;
            } else if (nums[mid] < nums[right]) {
                left = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
