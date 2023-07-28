package leetcode.problems;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2021-12-26 10:15 PM
 */
public class LeetCode673 {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxLength = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        //可能找到若干个j, i 都可以接在后面, 则都需要算进去
                        count[i] += count[j];
                    }
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLength) {
                res += count[i];
            }
        }
        return res;
    }

}
