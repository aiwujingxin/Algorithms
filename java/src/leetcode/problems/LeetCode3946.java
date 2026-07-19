package leetcode.problems;


import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 6/14/26 17:31
 */
public class LeetCode3946 {

    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        // 1. 找最便宜的商品价格
        int minCost = Integer.MAX_VALUE;
        for (int[] item : items) {
            minCost = Math.min(minCost, item[1]);
        }
        // 记录每个物品的代价和收益 (复用你的 cal 方法)
        int[] cost = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = items[i][1];
            value[i] = cal(items, i) + 1; // cal计算的是赠品，+1是包含自己
        }

        // 2. 替换贪心逻辑：使用 0/1 背包 DP 求出所有可能花费下的最大收益
        // dp[w] 表示【恰好】花费 w 预算时，能获得的最大物品数
        int[] dp = new int[budget + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            // 逆序遍历容量，典型的 0/1 背包写法
            for (int w = budget; w >= cost[i]; w--) {
                if (dp[w - cost[i]] != -1) {
                    dp[w] = Math.max(dp[w], dp[w - cost[i]] + value[i]);
                }
            }
        }
        // 3. 结合你的“剩余钱全买最便宜”的保底策略
        int ans = 0;
        for (int w = 0; w <= budget; w++) {
            if (dp[w] != -1) {
                // 当前组合的收益 + 剩下的钱无脑买最便宜的商品
                int currentTotal = dp[w] + (budget - w) / minCost;
                ans = Math.max(ans, currentTotal);
            }
        }
        return ans;
    }

    // 完全保留你原有的计算赠品逻辑
    private int cal(int[][] items, int i) {
        int cnt = 0;
        int t = items[i][0];
        for (int j = 0; j < items.length; j++) {
            if (i == j) continue;
            if (items[j][0] % t == 0) cnt++;
        }
        return cnt;
    }
}
