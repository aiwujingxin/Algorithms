package leetcode.hot100;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 01:44
 */
public class LeetCode287 {

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            // 这样写就不行: if (nums[mid - 1] == nums[mid] || nums[mid] == nums[mid + 1]) {
            if (nums[mid] == nums[mid + 1] || nums[mid - 1] == nums[mid]) {
                return nums[mid];
            } else if (nums[left] == nums[left + 1]) {
                return nums[left];
            } else if (nums[right] == nums[right - 1]) {
                return nums[right];
            } else {
                left++;
                right--;
            }
        }
        return -1;
    }
}
