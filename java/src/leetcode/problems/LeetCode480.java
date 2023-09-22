package leetcode.problems;

import java.util.Arrays;

import basic.datastructure.advance.TreapTree;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/28 23:13
 */
public class LeetCode480 {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new LeetCode480().medianSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));
        System.out.println(Arrays.toString(new LeetCode480().medianSlidingWindow(new int[] { 1, 4, 2, 3 }, 4)));

    }

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
