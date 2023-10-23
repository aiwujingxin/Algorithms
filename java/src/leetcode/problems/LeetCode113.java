package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/20 10:54
 */
public class LeetCode113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, new ArrayList<>(), targetSum);
        return res;
    }

    public void dfs(TreeNode root, List<List<Integer>> res, List<Integer> list, int targetSum) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            res.add(new ArrayList<>(list));
        }
        dfs(root.left, res, list, targetSum - root.val);
        dfs(root.right, res, list, targetSum - root.val);
        list.remove(list.size() - 1);
    }
}
