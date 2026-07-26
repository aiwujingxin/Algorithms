package knowledge.datastructure.adv.segtree;

/**
 * 带懒标记的线段树 (Lazy Propagation)。
 * 支持区间加法和区间求和。
 */
public class LazySegmentTree {
    private final long[] tree;
    private final long[] lazy;
    private final int n;

    public LazySegmentTree(int[] nums) {
        this.n = nums.length;
        this.tree = new long[n * 4];
        this.lazy = new long[n * 4];
        if (n > 0) build(nums, 0, 0, n - 1);
    }

    private void build(int[] nums, int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start];
            return;
        }
        int mid = start + (end - start) / 2;
        build(nums, node * 2 + 1, start, mid);
        build(nums, node * 2 + 2, mid + 1, end);
        tree[node] = tree[node * 2 + 1] + tree[node * 2 + 2];
    }

    private void pushDown(int node, int leftCount, int rightCount) {
        if (lazy[node] != 0) {
            lazy[node * 2 + 1] += lazy[node];
            lazy[node * 2 + 2] += lazy[node];
            tree[node * 2 + 1] += lazy[node] * leftCount;
            tree[node * 2 + 2] += lazy[node] * rightCount;
            lazy[node] = 0;
        }
    }

    /**
     * 区间 [L, R] 加上 val
     */
    public void add(int L, int R, long val) {
        add(L, R, val, 0, 0, n - 1);
    }

    private void add(int L, int R, long val, int node, int start, int end) {
        if (L <= start && R >= end) {
            lazy[node] += val;
            tree[node] += val * (end - start + 1);
            return;
        }
        int mid = start + (end - start) / 2;
        pushDown(node, mid - start + 1, end - mid);
        if (L <= mid) add(L, R, val, node * 2 + 1, start, mid);
        if (R > mid) add(L, R, val, node * 2 + 2, mid + 1, end);
        tree[node] = tree[node * 2 + 1] + tree[node * 2 + 2];
    }

    /**
     * 区间 [L, R] 求和
     */
    public long query(int L, int R) {
        return query(L, R, 0, 0, n - 1);
    }

    private long query(int L, int R, int node, int start, int end) {
        if (L <= start && R >= end) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        pushDown(node, mid - start + 1, end - mid);
        long sum = 0;
        if (L <= mid) sum += query(L, R, node * 2 + 1, start, mid);
        if (R > mid) sum += query(L, R, node * 2 + 2, mid + 1, end);
        return sum;
    }
}