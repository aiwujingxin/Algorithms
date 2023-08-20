package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/30 19:15
 */
public class LeetCode444_dp {

    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int[] sub = new int[n + 1];

        for (int i = 0; i < n; i++) {
            sub[nums[i]] = i;
        }

        for (List<Integer> sequence : sequences) {
            for (int j = 1; j < sequence.size(); j++) {
                if (sub[sequence.get(j)] - sub[sequence.get(j - 1)] == 1) {
                    dp[sub[sequence.get(j)]] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!dp[i]) {
                return false;
            }
        }
        return true;
    }
}
