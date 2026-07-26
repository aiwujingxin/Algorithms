package knowledge.datastructure.adv.BIT;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 树状数组：单点增加，前缀和与区间和查询，时间复杂度 O(log n)
 */
public class BITree {

    private final int[] tree;

    public BITree(int n) {
        tree = new int[n + 1];
    }

    public void add(int x, int delta) {
        for (int i = x; i < tree.length; i += i & -i) tree[i] += delta;
    }

    public int sum(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= i & -i) ans += tree[i];
        return ans;
    }

    public int rangeSum(int l, int r) {
        return sum(r) - sum(l - 1);
    }
}
