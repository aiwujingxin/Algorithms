package knowledge.datastructure.adv.BIT;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 双树状数组：区间增加与区间和查询，时间复杂度 O(log n)
 */
public class BITreeRange {

    private final long[] tree1;
    private final long[] tree2;
    private final int n;

    public BITreeRange(int n) {
        this.n = n;
        tree1 = new long[n + 1];
        tree2 = new long[n + 1];
    }

    private void add(long[] tree, int x, long delta) {
        for (int i = x; i <= n; i += i & -i) tree[i] += delta;
    }

    private long sum(long[] tree, int x) {
        long ans = 0;
        for (int i = x; i > 0; i -= i & -i) ans += tree[i];
        return ans;
    }

    public void rangeAdd(int l, int r, long delta) {
        add(tree1, l, delta);
        add(tree1, r + 1, -delta);
        add(tree2, l, delta * (l - 1));
        add(tree2, r + 1, -delta * r);
    }

    public long sum(int x) {
        return sum(tree1, x) * x - sum(tree2, x);
    }

    public long rangeSum(int l, int r) {
        return sum(r) - sum(l - 1);
    }
}
