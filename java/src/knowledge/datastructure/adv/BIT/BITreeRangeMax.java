package knowledge.datastructure.adv.BIT;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 树状数组维护任意区间最大值，仅支持单点值变大，查询复杂度 O(log n)
 */
public class BITreeRangeMax {

    private final long[] tree;
    private final long[] values;

    public BITreeRangeMax(int n) {
        tree = new long[n + 1];
        values = new long[n + 1];
        Arrays.fill(tree, Long.MIN_VALUE);
        Arrays.fill(values, Long.MIN_VALUE);
    }

    public void update(int x, long value) {
        if (value <= values[x]) return;
        values[x] = value;
        for (int i = x; i < tree.length; i += i & -i) {
            if (value <= tree[i]) break;
            tree[i] = value;
        }
    }

    public long rangeMax(int l, int r) {
        long ans = Long.MIN_VALUE;
        while (r >= l) {
            ans = Math.max(ans, values[r--]);
            while (r >= l && r - (r & -r) + 1 >= l) {
                ans = Math.max(ans, tree[r]);
                r -= r & -r;
            }
        }
        return ans;
    }
}
