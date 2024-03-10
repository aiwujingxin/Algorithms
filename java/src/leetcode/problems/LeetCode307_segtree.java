package leetcode.problems;

import knowledge.advstructure.SegTree;

/**
 * @author wujingxinit@outlook.com
 * @date 2023.11.08 22:26
 */
public class LeetCode307_segtree {

    class NumArray {

        private final int n;
        private final SegTree tree;

        public NumArray(int[] nums) {
            n = nums.length;
            this.tree = new SegTree(nums);
        }

        public void update(int index, int val) {
            tree.update(index, val, 0, 0, n - 1);
        }

        public int sumRange(int left, int right) {
            return tree.queryTree(left, right, 0, 0, n - 1);
        }
    }
}
