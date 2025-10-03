package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/4 00:54
 */
public class LeetCode526 {

    public int countArrangement_pull(int n) {
        int m = 1 << n;
        int[][] dp = new int[n + 1][m];
        dp[0][0] = 1;
        // Pull 模型：遍历目标状态，从前驱状态拉取数据
        for (int i = 1; i <= n; i++) {               // 阶段：处理第i个位置
            for (int curr = 0; curr < m; curr++) {            // 目标状态：最终的数字集合
                for (int k = 1; k <= n; k++) {       // 决策：尝试将数字k放在位置i
                    // 检查数字k是否在集合j中
                    if (((curr >> (k - 1)) & 1) == 0) {
                        continue;
                    }
                    // 检查数字k是否满足位置i的条件
                    if (k % i != 0 && i % k != 0) {
                        continue;
                    }
                    // 从前驱状态拉取数据：j去掉数字k
                    int prev = curr ^ (1 << (k - 1));
                    dp[i][curr] += dp[i - 1][prev];
                }
            }
        }
        return dp[n][m - 1];
    }

    public int countArrangement_push(int n) {
        int totalStates = 1 << n;  // 2^n 种状态
        int[][] dp = new int[n + 1][totalStates];

        // 初始化：没有放置任何数字时，只有1种方案
        dp[0][0] = 1;

        // Push模型：从已知状态推演到未知状态
        for (int pos = 0; pos < n; pos++) {                               // 当前已放置pos个数字
            for (int usedMask = 0; usedMask < totalStates; usedMask++) {  // 已使用的数字集合

                // 剪枝：如果当前状态不可达，跳过
                if (dp[pos][usedMask] == 0) continue;

                // 尝试将每个未使用的数字放在下一个位置(pos+1)
                for (int num = 1; num <= n; num++) {
                    int bit = 1 << (num - 1);

                    // 检查数字num是否已被使用
                    if ((usedMask & bit) != 0) continue;

                    // 检查数字num是否满足位置(pos+1)的条件
                    int nextPos = pos + 1;
                    if (num % nextPos != 0 && nextPos % num != 0) continue;

                    // 更新新状态：标记数字num为已使用
                    int newMask = usedMask | bit;
                    dp[nextPos][newMask] += dp[pos][usedMask];
                }
            }
        }

        // 最终结果：所有数字都被使用，且放置了n个位置
        return dp[n][totalStates - 1];
    }

    public int countArrangement_opt(int n) {
        int m = 1 << n;
        int[] dp = new int[m];
        dp[0] = 1;
        for (int mask = 0; mask < m; mask++) {
            int pos = Integer.bitCount(mask);  // 当前已放置的数字个数
            for (int num = 1; num <= n; num++) {
                int bit = 1 << (num - 1);
                if ((mask & bit) != 0) continue;
                if (num % (pos + 1) != 0 && (pos + 1) % num != 0) continue;
                dp[mask | bit] += dp[mask];
            }
        }
        return dp[m - 1];
    }

    public int countArrangement_dfs_memo(int n) {
        return dfs(n, 1, 0, new HashMap<>());
    }

    private int dfs(int n, int pos, int used, Map<Integer, Integer> memo) {
        if (pos > n) return 1;
        int key = (pos << 16) | used;  // 组合键
        if (memo.containsKey(key)) return memo.get(key);
        int count = 0;
        for (int num = 1; num <= n; num++) {
            int bit = 1 << num;
            if ((used & bit) == 0 && (num % pos == 0 || pos % num == 0)) {
                count += dfs(n, pos + 1, used | bit, memo);
            }
        }
        memo.put(key, count);
        return count;
    }

    public int countArrangement_bk(int n) {
        return backtrack(n, 1, new boolean[n + 1]);
    }

    private int backtrack(int n, int i, boolean[] used) {
        if (i > n) return 1;  // 所有位置都填完，找到一种方案
        int count = 0;
        for (int num = 1; num <= n; num++) {
            if (!used[num] && (num % i == 0 || i % num == 0)) {
                used[num] = true;
                count += backtrack(n, i + 1, used);
                used[num] = false;
            }
        }
        return count;
    }
}
