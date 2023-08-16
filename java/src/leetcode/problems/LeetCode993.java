package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/2 21:54
 */
public class LeetCode993 {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null && node.right != null) {
                    if (node.left.val == x && node.right.val == y || node.right.val == x && node.left.val == y) {
                        return false;
                    }
                }
                level.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            if (level.contains(x) && level.contains(y)) {
                return true;
            }
        }
        return false;
    }
}
