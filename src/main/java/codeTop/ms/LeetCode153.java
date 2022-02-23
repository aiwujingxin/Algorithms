package codeTop.ms;

/**
 * @author jingxinwu
 * @date 2022-02-17 7:12 PM
 */
public class LeetCode153 {

    //fix 没理解
    public int findMin(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);

    }

}
