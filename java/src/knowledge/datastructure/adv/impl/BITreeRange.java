package knowledge.datastructure.adv.impl;

/**
 * 区间修改 + 区间查询树状数组 (Range Update Range Query BIT)。
 * 基于差分数组 d[i]=a[i]-a[i-1]。设前缀和 sum(a,1..x) = Σ (x-i+1)·d[i]
 *   = (x+1)·Σd[i] - Σ i·d[i]。
 * 于是维护两个树状数组：t1 记录 d[i]，t2 记录 i·d[i]，即可 O(logN) 区间加、区间求和。
 */
public class BITreeRange {
    private final long[] t1; // 维护 d[i]
    private final long[] t2; // 维护 i*d[i]
    private final int n;

    public BITreeRange(int n) {
        this.n = n;
        this.t1 = new long[n + 1];
        this.t2 = new long[n + 1];
    }

    private void add(long[] t, int i, long v) {
        for (; i <= n; i += (i & -i)) t[i] += v;
    }

    private long sum(long[] t, int i) {
        long s = 0;
        for (; i > 0; i -= (i & -i)) s += t[i];
        return s;
    }

    /** 区间 [l, r] 每个元素加 v（1-indexed）。 */
    public void rangeAdd(int l, int r, long v) {
        add(t1, l, v);
        add(t1, r + 1, -v);
        add(t2, l, v * l);
        add(t2, r + 1, -v * (r + 1));
    }

    // 前缀和 a[1]+...+a[x]
    private long prefix(int x) {
        return (x + 1L) * sum(t1, x) - sum(t2, x);
    }

    /** 区间 [l, r] 的元素和。 */
    public long rangeSum(int l, int r) {
        return prefix(r) - prefix(l - 1);
    }
}
