package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/9 00:32
 */
public class LeetCode713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, ret = 0;
        int prod = 1, right = 0, left = 0;
        while (right < n) {
            prod *= nums[right];
            while (left <= right && prod >= k) {
                prod /= nums[left];
                left++;
            }
            ret += right - left + 1;
            right++;
        }
        return ret;
    }
}
