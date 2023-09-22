package leetcode.problems;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 22:03
 */
public class LeetCode1654_dp {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if (x == 0) return 0;
        HashSet<Integer> forb = new HashSet<>();
        for (int idx : forbidden) {
            forb.add(idx);
        }
        int[] dp = new int[Math.min(x + (a + b) * 3, 6000)];
        for (int i = 0; i < dp.length; i++) {
            if (!forb.contains(i) && (i == 0 || dp[i] != 0)) {
                if (!forb.contains(i + a) && i + a < dp.length) {
                    if (dp[i + a] == 0 || dp[i] + 1 < dp[i + a]) {
                        dp[i + a] = dp[i] + 1;
                    }
                }
                if (!forb.contains(i + a) && !forb.contains(i + a - b) && i + a - b >= 0 && i + a - b < dp.length) {
                    if (dp[i + a - b] == 0 || dp[i] + 2 < dp[i + a - b]) {
                        dp[i + a - b] = dp[i] + 2;
                        if (a - b < 0) i = i + a - b - 1;
                    }
                }
            }
        }
        return dp[x] == 0 ? -1 : dp[x];
    }
}
