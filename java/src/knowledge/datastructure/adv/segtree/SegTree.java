package knowledge.datastructure.adv.segtree;

/**
 * 基础线段树（静态开点，单点修改，区间查询）。
 * <p>
 * 时间复杂度:
 * - 建树: O(N)
 * - 单点修改: O(logN)
 * - 区间查询: O(logN)
 */
public class SegTree {
    private final int[] tree;
    private final int[] nums;
    private final int n;

    public SegTree(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.tree = new int[n * 4];
        if (n > 0) build(0, 0, n - 1);
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start];
            return;
        }
        int mid = start + (end - start) / 2;
        build(node * 2 + 1, start, mid);
        build(node * 2 + 2, mid + 1, end);
        tree[node] = tree[node * 2 + 1] + tree[node * 2 + 2];
    }

    public void update(int idx, int val) {
        update(idx, val, 0, 0, n - 1);
    }

    private void update(int idx, int val, int node, int start, int end) {
        if (start == end) {
            tree[node] = val;
            nums[idx] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) update(idx, val, node * 2 + 1, start, mid);
        else update(idx, val, node * 2 + 2, mid + 1, end);
        tree[node] = tree[node * 2 + 1] + tree[node * 2 + 2];
    }

    public int query(int L, int R) {
        return query(L, R, 0, 0, n - 1);
    }

    private int query(int L, int R, int node, int start, int end) {
        if (L <= start && R >= end) return tree[node];
        int mid = start + (end - start) / 2, sum = 0;
        if (L <= mid) sum += query(L, R, node * 2 + 1, start, mid);
        if (R > mid) sum += query(L, R, node * 2 + 2, mid + 1, end);
        return sum;
    }
}