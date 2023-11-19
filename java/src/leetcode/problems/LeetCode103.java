package leetcode.problems;

import common.TreeNode;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2023/10/27 15:02
 */
public class LeetCode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (flag) {
                Collections.reverse(level);
            }
            res.add(level);
            flag = !flag;
        }
        return res;
    }
}
