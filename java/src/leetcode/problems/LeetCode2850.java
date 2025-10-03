package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 9/24/25 17:53
 */
public class LeetCode2850 {

    public int minimumMoves(int[][] grid) {
        // 1. 收集所有石头的坐标
        List<int[]> stones = new ArrayList<>();
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                int count = grid[r][c];
                for (int k = 0; k < count; k++) {
                    stones.add(new int[]{r, c});
                }
            }
        }

        // 2. 目标位置
        List<int[]> targets = new ArrayList<>();
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                targets.add(new int[]{r, c});
            }
        }

        int n = stones.size(); // n = 9
        int totalStates = 1 << n;

        // 3. DP数组初始化
        int[] dp = new int[totalStates];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 4. 状态转移
        for (int mask = 0; mask < totalStates; mask++) {
            int k = Integer.bitCount(mask); // 已经分配了k个石头
            if (k >= n) continue;

            // 当前要分配第k个石头
            int[] stone = stones.get(k);

            for (int j = 0; j < n; j++) {
                // 如果目标位置j还没有被占用
                if ((mask & (1 << j)) == 0) {
                    int[] target = targets.get(j);
                    int dist = Math.abs(stone[0] - target[0]) + Math.abs(stone[1] - target[1]);
                    int newMask = mask | (1 << j);
                    if (dp[mask] != Integer.MAX_VALUE) {
                        dp[newMask] = Math.min(dp[newMask], dp[mask] + dist);
                    }
                }
            }
        }

        return dp[totalStates - 1];
    }
}
