package codeTop.ms;

import common.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jingxinwu
 * @date 2022-02-17 7:02 PM
 */
public class LeetCode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        queue.add(root);

        boolean flag = false;
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {

                level.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;

            }

            if (flag) {
                Collections.reverse(level);
            }
            list.add(level);
            flag = !flag;
        }

        return list;
    }

}
