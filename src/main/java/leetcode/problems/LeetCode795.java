package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/19 22:29
 */
public class LeetCode795 {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return getSubArr(nums, right) - getSubArr(nums, left - 1);
    }

    private int getSubArr(int[] nums, int max) {
        int n = nums.length;
        int res = 0;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (nums[right] > max) {
                left = right + 1;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }
}
