package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/17 20:51
 */
public class LeetCode845 {

    public int longestMountain(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int[] rdp = new int[n];
        Arrays.fill(rdp, 1);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                rdp[i] = rdp[i + 1] + 1;
            }
        }

        int max = 0;
        for (int i = 1; i < n - 1; i++) {
            if (dp[i] == 1 || rdp[i] == 1) {
                continue;
            }
            max = Math.max(max, dp[i] + rdp[i] - 1);
        }
        return max < 3 ? 0 : max;
    }
}
