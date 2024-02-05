package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
        if (set.contains(root.val)) {
            if (root.left != null) {
                TreeNode l = dfs(root.left);
                if (l != null) {
                    res.add(l);
                }
            }
            if (root.right != null) {
                TreeNode r = dfs(root.right);
                if (r != null) {
                    res.add(r);
                }
            }
            return null;
        }

        root.left = dfs(root.left);
        root.right = dfs(root.right);
        return root;
    }
}
