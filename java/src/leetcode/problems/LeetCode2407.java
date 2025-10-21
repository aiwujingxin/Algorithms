package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 10/21/25 21:52
 */
public class LeetCode2407 {

    int[] max;

    public int lengthOfLIS(int[] nums, int k) {
        var u = 0;
        for (var x : nums) u = Math.max(u, x);
        max = new int[u * 4];
        for (var x : nums) {
            if (x == 1) {
                modify(1, 1, u, 1, 1);
            } else {
                var res = 1 + query(1, 1, u, Math.max(x - k, 1), x - 1);
                modify(1, 1, u, x, res);
            }
        }
        return max[1];
    }

    private void modify(int o, int l, int r, int idx, int val) {
        if (l == r) {
            max[o] = val;
            return;
        }
        var m = (l + r) / 2;
        if (idx <= m) modify(o * 2, l, m, idx, val);
        else modify(o * 2 + 1, m + 1, r, idx, val);
        max[o] = Math.max(max[o * 2], max[o * 2 + 1]);
    }

    // 返回区间 [L,R] 内的最大值
    private int query(int o, int l, int r, int L, int R) { // L 和 R 在整个递归过程中均不变，将其大写，视作常量
        if (L <= l && r <= R) return max[o];
        var res = 0;
        var m = (l + r) / 2;
        if (L <= m) res = query(o * 2, l, m, L, R);
        if (R > m) res = Math.max(res, query(o * 2 + 1, m + 1, r, L, R));
        return res;
    }
}
