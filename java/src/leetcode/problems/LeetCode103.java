package leetcode.problems;

import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/16 14:36
 */
public class LeetCode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean rev = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (rev) {
                Collections.reverse(list);
            }
            rev = !rev;
            res.add(list);
        }
        return res;
    }
}
