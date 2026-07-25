package knowledge.datastructure.adv.impl;

import java.util.Arrays;

/**
 * 树状数组求前缀最大值。
 * 支持单点更新（只能变大），和求 [1, x] 的最大值。
 */
public class BITree_Max {
    private final long[] tree;

    public BITree_Max(int n) {
        this.tree = new long[n + 1];
        Arrays.fill(tree, Long.MIN_VALUE);
    }

    /**
     * 更新单点 x 的最大值为 val (x 1-indexed)
     */
    public void update(int x, long val) {
        for (int i = x; i < tree.length; i += (i & -i)) {
            tree[i] = Math.max(tree[i], val);
        }
    }

    /**
     * 查询 [1, x] 的最大值 (x 1-indexed)
     */
    public long max(int x) {
        long res = Long.MIN_VALUE;
        for (int i = x; i > 0; i -= (i & -i)) {
            res = Math.max(res, tree[i]);
        }
        return res;
    }
}