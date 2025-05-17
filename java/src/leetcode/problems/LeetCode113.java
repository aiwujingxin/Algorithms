package leetcode.problems;

import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/16 15:00
 */
public class LeetCode113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(root, targetSum, res, new ArrayList<>());
        return res;
    }

    private void backtrack(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                list.add(root.val);
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }
        list.add(root.val);
        backtrack(root.left, targetSum - root.val, res, list);
        backtrack(root.right, targetSum - root.val, res, list);
        list.remove(list.size() - 1);
    }
}
