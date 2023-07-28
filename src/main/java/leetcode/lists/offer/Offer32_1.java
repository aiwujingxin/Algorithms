package leetcode.lists.offer;

import common.*;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2021-11-21 8:57 下午
 */
public class Offer32_1 {

    public int[] levelOrder(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }


}
