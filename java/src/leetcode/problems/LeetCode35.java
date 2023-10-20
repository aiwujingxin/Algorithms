package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/20 11:13
 */
public class LeetCode35 {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] < target) {
            return left + 1;
        }
        return left;
    }
}
