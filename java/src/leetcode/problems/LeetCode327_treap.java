package leetcode.problems;

import knowledge.datastructure.tree.bst.TreapTree;

/**
 * @author wujingxinit@outlook.com
 * @date 4/13/25 16:46
 */
public class LeetCode327_treap {

    public int countRangeSum(int[] nums, int lower, int upper) {
        long sum = 0;
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            preSum[i + 1] = sum;
        }

        TreapTree treap = new TreapTree();
        int ret = 0;
        for (long x : preSum) {
            long numLeft = treap.getNextOrEq(x - upper);
            long rankLeft = (numLeft == Long.MAX_VALUE ? (int) (treap.getSize() + 1) : treap.getRankByKey(numLeft));
            long numRight = treap.getNext(x - lower);
            long rankRight = (numRight == Long.MAX_VALUE ? (int) treap.getSize() : treap.getRankByKey(numRight) - 1);
            ret += (int) (rankRight - rankLeft + 1);
            treap.insert(x);
        }
        return ret;
    }
}
