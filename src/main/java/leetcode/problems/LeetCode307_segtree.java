package leetcode.problems;

import basic.advstructure.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/23 18:08
 */
public class LeetCode307_segtree {

    class NumArray {

        private final int n;
        private final SegmentTree tree;

        public NumArray(int[] nums) {
            n = nums.length;
            this.tree = new SegmentTree(nums);
        }

        public void update(int index, int val) {
            tree.update(index, val, 0, 0, n - 1);
        }

        public int sumRange(int left, int right) {
            return tree.queryTree(left, right, 0, 0, n - 1);
        }
    }
}
