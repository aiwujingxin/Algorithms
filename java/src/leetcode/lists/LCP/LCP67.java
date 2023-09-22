package leetcode.lists.LCP;

import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/23 17:33
 */
public class LCP67 {

    public TreeNode expandBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    TreeNode l = node.left;
                    node.left = new TreeNode(-1);
                    node.left.left = l;
                    queue.add(l);
                }

                if (node.right != null) {
                    TreeNode r = node.right;
                    node.right = new TreeNode(-1);
                    node.right.right = r;
                    queue.add(r);
                }
            }
        }
        return root;
    }
}
