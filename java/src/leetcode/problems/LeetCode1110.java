package leetcode.problems;

import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/4 20:47
 */
public class LeetCode1110 {

    List<TreeNode> res;
    HashSet<Integer> set;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        res = new ArrayList<>();
        set = new HashSet<>();
        for (int j : to_delete) {
            set.add(j);
        }
        TreeNode node = dfs(root);
        if (node != null) {
            res.add(node);
        }
        return res;
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        if (set.contains(root.val)) {
            TreeNode l = dfs(root.left);
            if (l != null) {
                res.add(l);
            }
            TreeNode r = dfs(root.right);
            if (r != null) {
                res.add(r);
            }
            return null;
        }
        return root;
    }
}
