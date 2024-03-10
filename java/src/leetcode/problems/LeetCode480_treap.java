package leetcode.problems;

import knowledge.advstructure.bst.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/28 23:13
 */
public class LeetCode480_treap {

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] ans = new double[nums.length - k + 1];
        int n = nums.length;
        TreapTree tree = new TreapTree();
        int mid = k >> 1;
        for (int i = 0; i < n; i++) {
            tree.insert(nums[i]);
            if (i >= k - 1) {
                if ((k & 1) == 1) {
                    ans[i - k + 1] = tree.getKeyByRang(mid + 1);
                } else {
                    ans[i - k + 1] = (tree.getKeyByRang(mid) + (double) tree.getKeyByRang(mid + 1)) / 2;
                }
                tree.remove(nums[i - k + 1]);
            }
        }
        return ans;
    }
}
