package knowledge.datastructure.adv.impl;

/**
 * 树状数组 (Binary Indexed Tree / Fenwick Tree)。
 * 用于高效处理「单点更新」和「前缀和查询」。
 *
 * 时间复杂度:
 * - 单点更新: O(logN)
 * - 区间查询: O(logN)
 */
public class BITree {
    private final int[] tree;

    public BITree(int n) {
        // 树状数组下标从 1 开始
        this.tree = new int[n + 1];
    }

    /**
     * 单点增加: 在下标 x 处增加 val (x 1-indexed)
     */
    public void add(int x, int val) {
        for (int i = x; i < tree.length; i += (i & -i)) {
            tree[i] += val;
        }
    }

    /**
     * 前缀和查询: 求 [1, x] 的和 (x 1-indexed)
     */
    public int sum(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= (i & -i)) {
            res += tree[i];
        }
        return res;
    }
}