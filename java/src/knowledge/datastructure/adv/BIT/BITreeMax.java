package knowledge.datastructure.adv.BIT;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 树状数组维护前缀最大值，仅支持单点值变大，时间复杂度 O(log n)
 */
public class BITreeMax {

    private final long[] tree;

    public BITreeMax(int n) {
        tree = new long[n + 1];
        Arrays.fill(tree, Long.MIN_VALUE);
    }

    public void update(int x, long value) {
        for (int i = x; i < tree.length; i += i & -i) tree[i] = Math.max(tree[i], value);
    }

    public long max(int x) {
        long ans = Long.MIN_VALUE;
        for (int i = x; i > 0; i -= i & -i) ans = Math.max(ans, tree[i]);
        return ans;
    }
}
