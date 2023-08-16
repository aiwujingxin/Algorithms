package leetcode.problems;

import java.util.TreeSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/1 18:01
 */
public class LeetCode683_treeset {

    //https://leetcode.cn/problems/k-empty-slots/solution/k-ge-kong-hua-pen-by-beney-2-22uh/

    public int kEmptySlots(int[] bulbs, int k) {
        // 将每一次开花的位置存入排序结构 TreeSet 中，即按照位置排序
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < bulbs.length; i++) {
            // 每一次新开花，检查其左右位置的距离是否恰好==k
            int slot = bulbs[i];
            Integer low = set.lower(slot);
            if (low != null && slot - low == k + 1) {
                return i + 1;
            }
            Integer high = set.higher(slot);
            if (high != null && high - slot == k + 1) {
                return i + 1;
            }
            set.add(slot);
        }
        return -1;
    }
}
