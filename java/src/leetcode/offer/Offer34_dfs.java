package leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 18:12
 */
public class Offer34_dfs {

    List<List<Integer>> ret = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return ret;
    }

    public void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            ret.add(new LinkedList<>(path));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.pollLast();
    }
}
