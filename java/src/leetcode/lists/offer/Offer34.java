package leetcode.lists.offer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 23:27
 */
public class Offer34 {

    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        dfs(root, target, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, int target, List<Integer> temp) {
        if (root == null) {
            return;
        }
        if (target == root.val && root.left == null && root.right == null) {
            temp.add(root.val);
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            return;
        }
        temp.add(root.val);
        dfs(root.left, target - root.val, temp);
        dfs(root.right, target - root.val, temp);
        temp.remove(temp.size() - 1);
    }
}
