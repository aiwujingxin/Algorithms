package knowledge.datastructure.adv.BIT;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 权值树状数组：维护值频率，查询排名与第 k 小，时间复杂度 O(log n)
 */
public class BITreeKth {

    private final int[] tree;
    private final int n;

    public BITreeKth(int n) {
        this.n = n;
        tree = new int[n + 1];
    }

    public void add(int x, int delta) {
        for (int i = x; i <= n; i += i & -i) tree[i] += delta;
    }

    public int sum(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= i & -i) ans += tree[i];
        return ans;
    }

    public int kthSmallest(int k) {
        int idx = 0;
        for (int bitMask = Integer.highestOneBit(n); bitMask > 0; bitMask >>= 1) {
            int next = idx + bitMask;
            if (next <= n && tree[next] < k) {
                k -= tree[next];
                idx = next;
            }
        }
        return idx + 1;
    }
}
