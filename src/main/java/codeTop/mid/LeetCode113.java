package codeTop.mid;

import common.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jingxinwu
 * @date 2022-02-25 7:06 PM
 */
public class LeetCode113 {

    //
    Deque<Integer> path = new LinkedList<>();
    List<List<Integer>> list = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        dfs(root, targetSum);
        return list;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.right == null && root.left == null && 0 == targetSum) {
            list.add(new ArrayList<>(path));
            //fix
            // 不能直接return 需要回退操作path.pollLast();
//            return;
            return;

        }
        dfs(root.left, targetSum);

        dfs(root.right, targetSum);
        path.pollLast();
    }
}
