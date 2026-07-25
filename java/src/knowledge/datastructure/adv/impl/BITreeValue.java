package knowledge.datastructure.adv.impl;

/**
 * 权值树状数组 (Value-Indexed BIT)。
 * 下标即"值"（需先离散化到 [1, maxVal]），tree 记录每个值出现的次数。
 * 支持：插入/删除某个值、查询排名（≤x 的个数）、查询全局第 k 小（树上倍增二分 O(logN)）。
 * 逆序对亦可由"逆序插入 + 查询比当前值小的个数"求得。
 */
public class BITreeValue {
    private final int[] tree;
    private final int maxVal;
    private final int LOG;

    public BITreeValue(int maxVal) {
        this.maxVal = maxVal;
        this.tree = new int[maxVal + 1];
        this.LOG = 31 - Integer.numberOfLeadingZeros(maxVal);
    }

    /** 值 v 出现次数增加 delta（可为负表示删除）。 */
    public void add(int v, int delta) {
        for (int i = v; i <= maxVal; i += (i & -i)) tree[i] += delta;
    }

    /** ≤ v 的元素个数。 */
    public int countLE(int v) {
        int s = 0;
        for (int i = v; i > 0; i -= (i & -i)) s += tree[i];
        return s;
    }

    /**
     * 全局第 k 小的值（k 从 1 计）。树上倍增：从高位到低位尝试跳跃，累加不超过 k 的前缀。
     */
    public int kthSmallest(int k) {
        int pos = 0;
        int rest = k;
        for (int j = LOG; j >= 0; j--) {
            int next = pos + (1 << j);
            if (next <= maxVal && tree[next] < rest) {
                pos = next;
                rest -= tree[next];
            }
        }
        return pos + 1;
    }

    public static void main(String[] args) {
        // 插入 {1,3,3,5,7}，值域 <=7
        BITreeValue bv = new BITreeValue(7);
        for (int v : new int[]{1, 3, 3, 5, 7}) bv.add(v, 1);
        System.out.println("countLE(3) expect 3: " + bv.countLE(3));
        System.out.println("kthSmallest(1) expect 1: " + bv.kthSmallest(1));
        System.out.println("kthSmallest(3) expect 3: " + bv.kthSmallest(3));
        System.out.println("kthSmallest(4) expect 5: " + bv.kthSmallest(4));
        System.out.println("kthSmallest(5) expect 7: " + bv.kthSmallest(5));
    }
}
