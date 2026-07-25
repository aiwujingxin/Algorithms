package knowledge.datastructure.adv.impl;

/**
 * 树状数组求任意区间最大值。
 * 支持单点更新和任意区间 [L, R] 最大值查询。
 */
public class BITree_RangeMax {
    private final int n;
    private final long[] bit; // 覆盖块最大值
    private final long[] val; // 单点最大值

    public BITree_RangeMax(int n) {
        this.n = n;
        this.bit = new long[n + 1];
        this.val = new long[n + 1];
    }

    /**
     * 单点更新 x 处值为 v (仅支持变大) (x 1-indexed)
     */
    public void updateMax(int x, long v) {
        if (x <= 0 || x > n) return;
        if (v <= val[x]) return;
        val[x] = v;
        for (int i = x; i <= n; i += (i & -i)) {
            if (bit[i] < v) bit[i] = v;
            else break; // 剪枝
        }
    }

    /**
     * 查询区间 [L, R] 最大值 (1-indexed)
     */
    public long rangeMax(int L, int R) {
        L = Math.max(1, L);
        R = Math.min(n, R);
        if (L > R) return 0;
        
        long ans = 0;
        int y = R;
        while (y >= L) {
            ans = Math.max(ans, val[y]);
            y--;
            while (y >= L) {
                int lb = y & -y;
                if (y - lb + 1 < L) break;
                ans = Math.max(ans, bit[y]);
                y -= lb;
            }
        }
        return ans;
    }
}