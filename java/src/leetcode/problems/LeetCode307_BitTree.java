package leetcode.problems;

import basic.datastructure.advance.BinaryIndexedTree;

/**
 * @author wujingxinit@outlook.com
 * @date 2023.11.08 22:26
 */
public class LeetCode307_BitTree {

    class NumArray {

        BinaryIndexedTree bitTree;
        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            int n = nums.length;
            bitTree = new BinaryIndexedTree(n);
            for (int i = 0; i < nums.length; i++) {
                bitTree.update(i + 1, nums[i]);
            }
        }

        public void update(int index, int val) {
            bitTree.update(index + 1, val - nums[index]);
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            return bitTree.query(right + 1) - bitTree.query(left);
        }
    }
}
