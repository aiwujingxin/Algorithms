package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jingxinwu
 * @date 2021-08-13 2:10 上午
 */
public class LeetCode199 {

    public List<Integer> rightSideView(TreeNode root) {
        var view = new ArrayList<Integer>();
        if (root == null) {
            return view;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (var i = 0; i < size; i++) {
                var node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (i == size - 1) {
                    view.add(node.val);
                }
            }
        }

        return view;
    }
}
