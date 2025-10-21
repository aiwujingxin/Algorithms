package knowledge.datastructure.adv;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 10/21/25 21:44
 */
public class BITree_Max {

    long[] tree;

    public BITree_Max(int n) {
        tree = new long[n];
        Arrays.fill(tree, Long.MIN_VALUE);
    }

    public void update(int i, long val) {
        while (i < tree.length) {
            tree[i] = Math.max(tree[i], val);
            i += i & -i;
        }
    }

    public long max(int i) {
        long res = Long.MIN_VALUE;
        while (i > 0) {
            res = Math.max(res, tree[i]);
            i &= i - 1;
        }
        return res;
    }
}
