package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/25 02:22
 * @description Acwing1012友好城市 Acwing1016最大上升子序列和
 */
public class LeetCode1626 {

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] arrs = new int[n][];
        for (int i = 0; i < n; ++i) {
            arrs[i] = new int[]{scores[i], ages[i]};
        }
        Arrays.sort(arrs, (o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = arrs[i][0];
            for (int j = 0; j < i; j++) {
                if (arrs[i][0] >= arrs[j][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + arrs[i][0]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; ++i) res = Math.max(res, dp[i]);
        return res;
    }
}
