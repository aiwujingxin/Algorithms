package knowledge.algorithms.dp.optimizedp;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 决策单调性优化 (分治优化 DP)
 * <适用场景>
 * 转移 dp[i] = min_{j<i} ( dp'[j] + w(j+1, i) )，且最优决策点 opt[i] 随 i 单调不减时，
 * 用"分治求最优决策"把某一层从 O(n^2) 降到 O(n log n)。常见于 1D/1D 分组、四边形不等式代价。
 * <核心>
 * solve(l, r, optL, optR)：取中点 mid，在 [optL, optR] 内暴力找 mid 的最优决策 best，
 * 更新 dp[mid]；因决策单调，左半 [l,mid-1] 的决策落在 [optL,best]，右半在 [best,optR]，递归即可。
 * @see knowledge.algorithms.dp.intervaldp.problems.AcWing282 石子合并 (决策单调性)
 * @see SlopeOptimization 斜率优化 (决策单调性的凸壳特例)
 */
public class DecisionMonotonicity {

    private long[] prev; // 上一层 dp
    private long[] cur;  // 当前层 dp
    private long[] sum;  // 前缀和，用于 O(1) 计算区间代价

    /**
     * 把长度 n 的数组恰好分成 k 段，每段代价为"段内元素和的平方"，求最小总代价。
     * 分层 DP：第 t 层 cur[i] 表示前 i 个元素分成 t 段的最小代价，层内用决策单调性分治。
     */
    public long minCost(int[] arr, int k) {
        int n = arr.length;
        sum = new long[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + arr[i - 1];
        prev = new long[n + 1];
        cur = new long[n + 1];
        // 第 1 段：整段 [1,i] 的代价
        for (int i = 1; i <= n; i++) prev[i] = cost(0, i);
        for (int t = 2; t <= k; t++) {
            java.util.Arrays.fill(cur, Long.MAX_VALUE);
            solve(t, t, n, t - 1, n - 1); // 第 t 层，i∈[t,n]，决策 j∈[t-1,n-1]
            long[] temp = prev;
            prev = cur;
            cur = temp;
        }
        return prev[n];
    }

    // 段 (j, i] 的代价 = (sum[i]-sum[j])^2
    private long cost(int j, int i) {
        long w = sum[i] - sum[j];
        return w * w;
    }

    // 对第 t 层的区间 [l,r]，其最优决策落在 [optL,optR]，分治求解
    private void solve(int t, int l, int r, int optL, int optR) {
        if (l > r) return;
        int mid = (l + r) >>> 1;
        int best = -1;
        long bestVal = Long.MAX_VALUE;
        int hi = Math.min(mid - 1, optR);
        for (int j = optL; j <= hi; j++) {
            if (prev[j] == Long.MAX_VALUE) continue;
            long val = prev[j] + cost(j, mid);
            if (val < bestVal) {
                bestVal = val;
                best = j;
            }
        }
        cur[mid] = bestVal;
        solve(t, l, mid - 1, optL, best);
        solve(t, mid + 1, r, best, optR);
    }

    public static void main(String[] args) {
        // {1,2,3,4} 分 2 段：最优 [1,2]|[3,4] => 9+49=58? 或 [1,2,3]|[4] => 36+16=52
        // 枚举: (1)(234)=1+81=82;(12)(34)=9+49=58;(123)(4)=36+16=52 -> min 52
        System.out.println("minCost expect 52: " + new DecisionMonotonicity().minCost(new int[]{1, 2, 3, 4}, 2));
    }
}
