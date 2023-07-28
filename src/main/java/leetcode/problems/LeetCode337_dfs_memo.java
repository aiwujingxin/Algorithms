package leetcode.problems;

import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/23 13:37
 */
public class LeetCode337_dfs_memo {

    HashMap<TreeNode, Integer> memo;

    public int rob(TreeNode root) {
        memo = new HashMap<>();
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        int money = root.val;

        if (root.left != null) {
            money += (dfs(root.left.left) + dfs(root.left.right));
        }
        if (root.right != null) {
            money += (dfs(root.right.left) + dfs(root.right.right));
        }
        int result = Math.max(money, dfs(root.left) + dfs(root.right));
        memo.put(root, result);
        return result;
    }
}
