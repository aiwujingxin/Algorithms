package leetcode.problems;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/25 22:16
 * @see LeetCode300_bs
 */
public class LeetCode354 {

    //https://leetcode.com/problems/russian-doll-envelopes/discuss/1734526/Java-LIS-Revisited-or-Binary-Search-Best-Explanation
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        //dp[i] 代表着表示h的前 i 个元素可以组成的长度为 j 的最长严格递增子序列的末尾元素的最小值
        int[] dp = new int[envelopes.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = Integer.MIN_VALUE;
        int ans = 0;
        for (int[] envelope : envelopes) {
            int val = envelope[1];
            int insertIndex = binarySearch(dp, val);
            if (dp[insertIndex] >= val) {
                dp[insertIndex] = val;
            }
            ans = Math.max(ans, insertIndex);
        }
        return ans;
    }

    public int binarySearch(int[] nums, int target) {
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
