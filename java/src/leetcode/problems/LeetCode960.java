package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/25 02:34
 */
public class LeetCode960 {

    public int minDeletionSize(String[] strs) {
        int m = strs[0].length();
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < i; j++) {
                boolean sorted = true;
                for (String str : strs) {
                    if (str.charAt(j) > str.charAt(i)) {
                        sorted = false;
                        break;
                    }
                }
                if (sorted) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxRemain = 0;
        for (int remain : dp) {
            maxRemain = Math.max(maxRemain, remain);
        }
        return m - maxRemain;
    }
}
