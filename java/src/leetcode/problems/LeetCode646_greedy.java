package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/28 17:59
 */
public class LeetCode646_greedy {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int len = 0;
        for (int[] num : pairs) {
            int l = 0, r = len;
            while (l < r) {
                int mid = l + r >> 1;
                if (dp[mid] < num[0])
                    l = mid + 1;
                else
                    r = mid;
            }
            if (len == 0 || num[0] > dp[l]) {
                dp[l] = num[1];
                len++;
            } else if (num[1] < dp[l]) {
                dp[l] = num[1];
            }
        }
        return len;
    }
}
