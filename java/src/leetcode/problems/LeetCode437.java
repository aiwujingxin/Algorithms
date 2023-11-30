package leetcode.problems;

import common.TreeNode;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/29 18:44
 * @see LeetCode560
 */
public class LeetCode437 {
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return res;
    }

    private void dfs(TreeNode root, long sum, int targetSum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        if (sum == targetSum) {
            res++;
        }
        dfs(root.left, sum, targetSum);
        dfs(root.right, sum, targetSum);
    }

    public int pathSum_opt(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return dfs(map, root, 0, targetSum);
    }

    public int dfs(HashMap<Long, Integer> map, TreeNode root, long sum, int targetSum) {
        if (root == null) {
            return 0;
        }
        sum += root.val;
        int ret;
        ret = map.getOrDefault(sum - targetSum, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        ret += dfs(map, root.left, sum, targetSum);
        ret += dfs(map, root.right, sum, targetSum);
        map.put(sum, map.getOrDefault(sum, 0) - 1);
        return ret;
    }
}


