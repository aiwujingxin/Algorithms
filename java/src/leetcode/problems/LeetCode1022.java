package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 15:30
 */
public class LeetCode1022 {

    int ans;

    public int sumRootToLeaf(TreeNode root) {
        findSum(root, 0);
        return ans;
    }

    public void findSum(TreeNode t, int sum) {
        if (t.left == null && t.right == null) {
            ans += sum * 2 + t.val;
            return;
        }
        if (t.left != null) {
            findSum(t.left, 2 * sum + t.val);
        }
        if (t.right != null) {
            findSum(t.right, 2 * sum + t.val);
        }
    }
}

