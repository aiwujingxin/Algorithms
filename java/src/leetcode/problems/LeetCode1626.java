package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/25 02:22
 */
public class LeetCode1626 {

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] arr = new int[n][];
        for (int i = 0; i < n; ++i) {
            arr[i] = new int[]{scores[i], ages[i]};
        }
        Arrays.sort(arr, (o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i][0];
            for (int j = 0; j < i; j++) {
                if (arr[i][0] >= arr[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i][0]);
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) sum = Math.max(sum, dp[i]);
        return sum;
    }
}
