package leetcode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        var q = new LinkedList<TreeNode>();
        q.add(root);

        while (!q.isEmpty()) {
            var levelSize = q.size();
            for (var i = 0; i < levelSize; i++) {
                var currentNode = q.poll();
                if (currentNode.left != null) {
                    q.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }
                if (i == levelSize - 1) {
                    view.add(currentNode.val);
                }
            }
        }

        return view;
    }
}
