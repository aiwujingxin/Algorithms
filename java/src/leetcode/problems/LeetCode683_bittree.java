package leetcode.problems;

import knowledge.advstructure.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/1 18:00
 */
public class LeetCode683_bittree {

    public int kEmptySlots(int[] bulbs, int k) {
        int n = bulbs.length;
        BITree tree = new BITree(n + 1);
        boolean[] on = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            // 左侧间隔k个的灯泡是否存在并且亮了，和当前位置的前缀和是否相等
            if (bulbs[i] - k - 1 > 0 && on[bulbs[i] - k - 1] && (tree.sum(bulbs[i]) == tree.sum(bulbs[i] - k - 1))) {
                return i + 1;
            }
            // 右侧间隔k个的灯泡是否存在并且亮和，和当前位置的前缀和是否相等
            if (bulbs[i] + k + 1 <= n && on[bulbs[i] + k + 1] && (tree.sum(bulbs[i]) == tree.sum(bulbs[i] + k))) {
                return i + 1;
            }
            on[bulbs[i]] = true;
            tree.add(bulbs[i], 1);
        }
        return -1;
    }
}
