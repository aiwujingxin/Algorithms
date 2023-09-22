package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/20 22:03
 */
public class LeetCode1110_dfs {

    HashSet<Integer> set;
    ArrayList<TreeNode> ans;

    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        ans = new ArrayList<>();
        set = new HashSet<>();
        for (int x : toDelete) {
            set.add(x);
        }
        if (dfs(root) != null) {
            ans.add(root);
        }
        return ans;
    }

    private TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }
        node.left = dfs(node.left);
        node.right = dfs(node.right);
        if (!set.contains(node.val)) {
            return node;
        }
        if (node.left != null) {
            ans.add(node.left);
        }
        if (node.right != null) {
            ans.add(node.right);
        }
        return null;
    }
}
