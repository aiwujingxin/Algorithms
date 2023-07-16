package leetcode.problems;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/10 20:50
 */
public class LeetCode437_v2 {

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);

        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);

        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }
}
