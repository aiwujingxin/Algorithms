package knowledge.datastructure.adv;

/**
 * @author wujingxinit@outlook.com
 * @date 10/21/25 22:05
 * @description 树状数组（BIT Tree）的基础上，扩展支持任意区间 [L, R] 最大值查询的实现。
 */
public class BITree_RangeMax {

    private final int n;
    private final long[] bit; // 覆盖块最大值
    private final long[] val; // 单点最大值

    public BITree_RangeMax(int n) {
        this.n = n;
        this.bit = new long[n + 1];
        this.val = new long[n + 1];
        // 默认全 0：多数 DP（max + 非负允许）场景下可用
        // 若需要“空”为 -INF，可用 Arrays.fill(..., Long.MIN_VALUE) 并调整返回逻辑
    }

    private static int lowbit(int x) {
        return x & -x;
    }

    // 单点取最大并向上维护块最大值：val[x] = max(val[x], v), 同时维护 bit
    public void updateMax(int x, long v) {
        if (x <= 0 || x > n) return;
        long cur = val[x];
        if (v <= cur) return;
        val[x] = v;
        for (int i = x; i <= n; i += lowbit(i)) {
            if (bit[i] < v) bit[i] = v;
            else break; // 剪枝：若当前块已经 >= v，则父块也大概率满足，提前退出
        }
    }

    // 区间最大值 [L, R]（空区间返回 0）
    public long rangeMax(int L, int R) {
        if (L > R) return 0;
        if (L < 1) L = 1;
        if (R > n) R = n;

        long ans = 0;
        int y = R;
        while (y >= L) {
            // 先吃掉 y 的单点
            long vy = val[y];
            if (vy > ans) ans = vy;
            y--;

            // 尽量整块跳降
            while (y >= L) {
                int lb = lowbit(y);
                int start = y - lb + 1; // 这个块覆盖 [start .. y]
                if (start < L) break;   // 块左边越界了，不能整块用
                long by = bit[y];
                if (by > ans) ans = by;
                y -= lb;
            }
        }
        return ans;
    }
}
