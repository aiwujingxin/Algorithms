package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2021-08-04 11:58 下午
 */
public class LeetCode153 {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
