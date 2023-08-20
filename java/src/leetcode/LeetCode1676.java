package leetcode;

import common.TreeNode;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/21 16:21
 */
public class LeetCode1676 {

    HashSet<Integer> set;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {

        set = new HashSet<>();

        for (TreeNode node : nodes) {
            set.add(node.val);
        }
        return dfs(root);

    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (set.contains(root.val)) {
            return root;
        }

        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);

        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }
}
