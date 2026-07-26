package knowledge.datastructure.adv.BIT;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 权值树状数组：维护值频率，查询排名与第 k 小，时间复杂度 O(log n)
 */
public class BITreeKth {

    private final int[] tree;
    private final int n;
    private final int highBit;

    public BITreeKth(int n) {
        this.n = n;
        tree = new int[n + 1];
        highBit = Integer.highestOneBit(n);
    }

    public void add(int v, int delta) {
        for (int i = v; i <= n; i += i & -i) tree[i] += delta;
    }

    public int countLE(int v) {
        int ans = 0;
        for (int i = v; i > 0; i -= i & -i) ans += tree[i];
        return ans;
    }

    public int kthSmallest(int k) {
        int pos = 0;
        for (int step = highBit; step > 0; step >>= 1) {
            int next = pos + step;
            if (next <= n && tree[next] < k) {
                pos = next;
                k -= tree[next];
            }
        }
        return pos + 1;
    }
}
