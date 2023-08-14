package leetcode.problems;

import common.TreeNode;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/14 18:10
 */
public class LeetCode437_pre {


    int targetSum;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        this.targetSum = targetSum;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return (int) dfs(map, root, 0);
    }

    public long dfs(HashMap<Long, Integer> map, TreeNode root, long sum) {
        if (root == null) {
            return 0;
        }
        sum += root.val;
        long ret;

        ret = map.getOrDefault(sum - targetSum, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        ret += (int) dfs(map, root.left, sum);
        ret += (int) dfs(map, root.right, sum);
        map.put(sum, map.getOrDefault(sum, 0) - 1);
        return ret;
    }
}
