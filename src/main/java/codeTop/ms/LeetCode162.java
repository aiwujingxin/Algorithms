package codeTop.ms;

/**
 * @author jingxinwu
 * @date 2022-02-23 1:49 PM
 */
public class LeetCode162 {

    public int findPeakElement(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;

            }
        }

        return Math.max(nums[left], nums[right]);

    }

}
