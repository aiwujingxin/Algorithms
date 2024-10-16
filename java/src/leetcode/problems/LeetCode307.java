package leetcode.problems;

import knowledge.datastructure.adv.BITree;

/**
 * @author wujingxinit@outlook.com
 * @date 2024.01.04 22:26
 */
public class LeetCode307 {

    class NumArray {

        BITree bitTree;
        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            int n = nums.length;
            bitTree = new BITree(n);
            for (int i = 0; i < nums.length; i++) {
                bitTree.add(i + 1, nums[i]);
            }
        }

        public void update(int index, int val) {
            bitTree.add(index + 1, val - nums[index]);
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            return bitTree.sum(right + 1) - bitTree.sum(left);
        }
    }
}
