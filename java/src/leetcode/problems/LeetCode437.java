package leetcode.problems;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/25 17:36
 */
public class LeetCode437 {

    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        dfs(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return res;
    }

    private void dfs(TreeNode root, long targetSum) {
        if (root == null) {
            return;
        }
        if (root.val == targetSum) {
            res++;
        }
        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
    }

    class Solution_presum {

        public int pathSum(TreeNode root, int targetSum) {
            Map<Long, Integer> presum = new HashMap<>();
            presum.put(0L, 1);
            return dfs(root, 0L, targetSum, presum);
        }

        private int dfs(TreeNode node, long cur, int targetSum, Map<Long, Integer> presum) {
            if (node == null) return 0;
            int res = 0;
            cur += node.val;
            res += presum.getOrDefault(cur - targetSum, 0);
            presum.merge(cur, 1, Integer::sum);

            res += dfs(node.left, cur, targetSum, presum);
            res += dfs(node.right, cur, targetSum, presum);

            presum.merge(cur, -1, Integer::sum);
            return res;
        }
    }
}
