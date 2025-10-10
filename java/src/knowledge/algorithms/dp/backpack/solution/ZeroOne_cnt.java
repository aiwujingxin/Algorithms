package knowledge.algorithms.dp.backpack.solution;

import knowledge.algorithms.dp.backpack.zeroOne.ZeroOnePack;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 10/10/25 15:36
 * @description 01背包 方案数
 * @see leetcode.problems.LeetCode518
 */
public class ZeroOne_cnt implements ZeroOnePack {

    public int backPack(int[] C, int[] W, int V) {
        int[] dp = new int[V + 1];
        int[] cnt = new int[V + 1];
        Arrays.fill(cnt, 1);
        for (int i = 0; i < C.length; i++) {
            for (int v = V; v >= C[i]; v--) {
                if (dp[v] < dp[v - C[i]] + W[i]) {
                    cnt[v] = cnt[v - C[i]];
                } else if (dp[v - C[i]] + W[i] == dp[v]) {
                    cnt[v] += cnt[v - C[i]];
                }
                dp[v] = Math.max(dp[v], dp[v - C[i]] + W[i]);
            }
        }
        System.out.println("最优选法的方案数:" + cnt[V]);
        return dp[V];
    }
}
