package leetcode.lists.hot200;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/1 18:00
 */
public class LeetCode693_bittree {

    private int[] it;
    private int length;

    public int kEmptySlots(int[] bulbs, int k) {
        int n = bulbs.length;
        length = n;
        it = new int[n + 1];
        boolean[] on = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            // 左侧间隔k个的灯泡是否存在并且亮了，和当前位置的前缀和是否相等
            if (bulbs[i] - k - 1 > 0 && on[bulbs[i] - k - 1] && (query(bulbs[i]) == query(bulbs[i] - k - 1))) {
                return i + 1;
            }
            // 右侧间隔k个的灯泡是否存在并且亮和，和当前位置的前缀和是否相等
            if (bulbs[i] + k + 1 <= n && on[bulbs[i] + k + 1] && (query(bulbs[i]) == query(bulbs[i] + k))) {
                return i + 1;
            }
            on[bulbs[i]] = true;
            update(bulbs[i]);
        }

        return -1;
    }

    private void update(int i) {
        while (i <= length) {
            it[i]++;
            i += i & -i;
        }
    }

    private int query(int i) {
        int ret = 0;
        while (i > 0) {
            ret += it[i];
            i -= i & -i;
        }

        return ret;
    }
}
