package leetcode.competition.weekly.week335;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/5 21:52
 */
public class LeetCode6310 {
    private static final int MOD = (int) 1e9 + 7;

    public int waysToReachTarget(int target, int[][] types) {
        var f = new int[target + 1];
        f[0] = 1;
        for (var p : types) {
            int count = p[0], marks = p[1];
            for (int j = target; j > 0; j--) {
                for (int k = 1; k <= count && k <= j / marks; ++k) {
                    f[j] = (f[j] + f[j - k * marks]) % MOD;
                }
            }
        }
        return f[target];
    }

    public int waysToReachTarget_DP_2D(int target, int[][] types) {
        int[][] dp = new int[types.length + 1][target + 1];
        for (int i = 0; i <= types.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < types.length; i++) {
            for (int j = 1; j <= target; j++) {
                for (int k = 0; k <= types[i][0] && k * types[i][1] <= j; k++) {
                    dp[i + 1][j] = (dp[i + 1][j] + dp[i][j - k * types[i][1]]) % 1000000007;
                }
            }
        }
        return dp[types.length][target];
    }


    int[][] cache;

    public int waysToReachTarget_DFS(int target, int[][] types) {
        cache = new int[target + 1][types.length + 1];
        for (int[] ints : cache) {
            Arrays.fill(ints, -1);
        }
        return dfs(target, 0, types);
    }

    public int dfs(int target, int index, int[][] types) {

        if (target == 0) {
            return 1;
        }
        if (index >= types.length) {
            return 0;
        }
        //记忆状态
        if (cache[target][index] != -1) {
            return cache[target][index];
        }

        int ans = 0;
        int num = types[index][0];
        int point = types[index][1];
        int count = 0;
        //每个种类可能获得的分数可能性
        while (count <= num && target >= point * count) {
            ans = (ans + dfs(target - point * count, index + 1, types)) % 1000000007;
            count++;
        }
        cache[target][index] = ans;
        return ans;
    }
}
