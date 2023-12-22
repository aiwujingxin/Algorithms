package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/25 01:29
 */
public class LeetCode540 {

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == nums[mid ^ 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}

