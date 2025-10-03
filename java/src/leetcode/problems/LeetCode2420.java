package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 9/4/25 17:02
 */
public class LeetCode2420 {

    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = k; i < n - k; i++) {
            if (left[i - 1] >= k && right[i + 1] >= k) {
                ans.add(i);
            }
        }
        return ans;
    }
}
