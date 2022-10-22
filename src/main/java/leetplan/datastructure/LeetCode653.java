package leetplan.datastructure;

import common.TreeNode;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/18 22:45
 */
public class LeetCode653 {


    HashSet<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        return dfs(root, k);
    }

    private boolean dfs(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return dfs(root.left, k) || dfs(root.right, k);
    }
}
