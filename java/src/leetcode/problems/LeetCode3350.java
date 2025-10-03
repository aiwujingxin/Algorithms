package leetcode.problems;

import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 9/9/25 17:09
 */
public class LeetCode3350 {

    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            res = Math.max(res, Math.min(left[i], right[i + 1]));
        }
        return res;
    }
}
