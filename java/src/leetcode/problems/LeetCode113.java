package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/27 18:35
 */
public class LeetCode113 {

    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.right == null && root.left == null) {
            if (targetSum == root.val) {
                list.add(root.val);
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }
        list.add(root.val);
        dfs(root.left, targetSum - root.val, list);
        dfs(root.right, targetSum - root.val, list);
        list.remove(list.size() - 1);
    }
}
