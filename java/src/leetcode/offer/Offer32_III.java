package leetcode.offer;

import common.TreeNode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 23:25
 */
public class Offer32_III {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
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
            flag = !flag;
            list.add(level);
        }
        return list;
    }
}
