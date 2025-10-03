package leetcode.problems;

import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 9/23/25 17:20
 */
public class LeetCode3376 {

    public int findMinimumTime(List<Integer> s, int k) {
        int n = s.size();
        int m = 1 << n;
        int[] dp = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < m; i++) {                   // 阶段 枚举所有要计算的目标状态 i
            for (int j = 0; j < n; j++) {               // 状态 枚举状态 i 中的每一把锁 j，假设 j 是最后一把被打开的
                if (((i >> j) & 1) == 0) continue;
                // 前一个状态是 i 中不包含 j 的状态
                dp[i] = Math.min(dp[i], dp[i ^ (1 << j)] + (int) Math.ceil((double) s.get(j) / (1 + k * (Integer.bitCount(i) - 1))));
            }
        }
        return dp[m - 1];
    }
}
