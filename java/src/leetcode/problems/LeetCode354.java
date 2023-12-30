package leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/25 22:16
 * @link <a href="https://leetcode.com/problems/russian-doll-envelopes/discuss/1734526/Java-LIS-Revisited-or-Binary-Search-Best-Explanation">...</a>
 * @see LeetCode300_bs
 */
public class LeetCode354 {

    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });

        //dp[i] 代表着表示h的前 i 个元素可以组成的长度为 j 的最长严格递增子序列的末尾元素的最小值
        int[] dp = new int[envelopes.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = Integer.MIN_VALUE;
        int res = 0;
        for (int[] envelope : envelopes) {
            int num = envelope[1];
            int insertIndex = leftBound(dp, num);
            dp[insertIndex] = Math.min(dp[insertIndex], num);
            res = Math.max(res, insertIndex);
        }
        return res;
    }

    public int leftBound(int[] nums, int target) {
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
