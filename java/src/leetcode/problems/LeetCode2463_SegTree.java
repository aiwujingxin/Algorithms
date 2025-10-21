package leetcode.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 10/21/25 21:38
 */
public class LeetCode2463_SegTree {

    static final long INF = Long.MAX_VALUE / 4;

    // 线段树：维护最小值，支持点更新 + 区间查询
    static class SegTree {
        int n;
        long[] st;

        SegTree(int n) {
            this.n = n;
            this.st = new long[4 * n];
            Arrays.fill(st, INF);
        }

        void clear() {
            Arrays.fill(st, INF);
        }

        void update(int idx, long val) {
            update(1, 0, n - 1, idx, val);
        }

        private void update(int p, int l, int r, int idx, long val) {
            if (l == r) {
                st[p] = val;
                return;
            }
            int mid = (l + r) >>> 1;
            if (idx <= mid) update(p << 1, l, mid, idx, val);
            else update(p << 1 | 1, mid + 1, r, idx, val);
            st[p] = Math.min(st[p << 1], st[p << 1 | 1]);
        }

        long query(int L, int R) {
            if (L > R) return INF;
            return query(1, 0, n - 1, L, R);
        }

        private long query(int p, int l, int r, int L, int R) {
            if (L <= l && r <= R) return st[p];
            int mid = (l + r) >>> 1;
            long res = INF;
            if (L <= mid) res = Math.min(res, query(p << 1, l, mid, L, R));
            if (R > mid) res = Math.min(res, query(p << 1 | 1, mid + 1, r, L, R));
            return res;
        }
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        // 排序
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
        Collections.sort(robot);
        int n = factory.length, m = robot.size();
        // dp[i][j]：前 i 家工厂覆盖前 j 个机器人的最小代价
        long[][] dp = new long[n + 1][m + 1];
        Arrays.fill(dp[0], INF);
        dp[0][0] = 0;
        SegTree seg = new SegTree(m); // 维护 t ∈ [0..m-1]
        for (int i = 1; i <= n; i++) {
            int pos = factory[i - 1][0];
            int cap = factory[i - 1][1];
            // sum[j] = Σ_{k=1..j} |pos - robot[k-1]|
            long[] sum = new long[m + 1];
            for (int j = 1; j <= m; j++) {
                sum[j] = sum[j - 1] + Math.abs((long) pos - robot.get(j - 1));
            }
            // 初始化第 i 行
            dp[i][0] = 0;
            Arrays.fill(dp[i], 1, m + 1, INF);
            // 用 dp[i-1][t] 构建当前 i 的线段树（动态插入）
            seg.clear();
            for (int j = 1; j <= m; j++) {
                // 选项1：不使用第 i 家工厂
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                // 插入 t = j-1 的候选
                if (dp[i - 1][j - 1] != INF) {
                    long val = dp[i - 1][j - 1] - sum[j - 1]; // V[t]
                    seg.update(j - 1, val);
                }
                // 查询窗口 [j - cap, j - 1] 的最小 V[t]
                int L = Math.max(0, j - cap);
                int R = j - 1;
                long minV = seg.query(L, R);
                if (minV != INF) {
                    dp[i][j] = Math.min(dp[i][j], minV + sum[j]);
                }
            }
        }
        return dp[n][m];
    }
}

