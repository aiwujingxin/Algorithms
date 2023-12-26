package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/15 18:26
 */
public class LeetCode1855 {

    public int maxDistance(int[] nums1, int[] nums2) {
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            int index = rightBound(nums2, nums1[i]);
            if (index < i) {
                continue;
            }
            res = Math.max(index - i, res);
        }
        return res;
    }

    private int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (nums[mid] < target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (nums[left] < target) {
            return -1;
        }
        return left;
    }
}
