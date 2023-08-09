package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/2 15:41
 */
public class LeetCode1182_dp {

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int n = colors.length;
        final int INF = 50005;
        int[][] dp = new int[n][3];
        //dp[i][j] : 位置i到颜色j的最短距离

        for (int[] pos : dp) {
            Arrays.fill(pos, INF);
        }

        //每个位置到自己颜色的距离置1
        for (int i = 0; i < n; i++) {
            dp[i][colors[i] - 1] = 0;
        }

        //从左向右遍历，dp[i][j] = min(dp[i-1][j] + 1, dp[i][j])
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (dp[i - 1][j] != INF) {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j]);
                }
            }
        }

        //从右向左遍历，dp[i][j] = min(dp[i+1][j] + 1, dp[i][j])
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                if (dp[i + 1][j] != INF) {
                    dp[i][j] = Math.min(dp[i + 1][j] + 1, dp[i][j]);
                }
            }
        }

        //若位置i与某颜色不可达，置-1，结果加入数组
        List<Integer> list = new ArrayList<>();
        for (int[] querie : queries) {
            int distance = dp[querie[0]][querie[1] - 1];
            list.add((distance == INF) ? -1 : distance);
        }
        return list;
    }
}
