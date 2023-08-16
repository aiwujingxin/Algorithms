package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/4 17:35
 */
public class LeetCode239_dp {

    //https://leetcode.com/problems/sliding-window-maximum/discuss/458121/Java-All-Solutions-(B-F-PQ-Deque-DP)-with-Explanation-and-Complexity-Analysis

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // left & right
        int[] left = new int[n];
        int[] right = new int[n];
        // init
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; ++i) {
            // left
            if (i % k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }
            // right
            int j = n - i - 1;
            if (j % k == (k - 1)) {
                right[j] = nums[j];
            } else {
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }

        // dp
        for (int i = 0, j = i + k - 1; j < n; ++i, ++j) {
            result[i] = Math.max(right[i], left[j]);
        }

        return result;
    }
}
