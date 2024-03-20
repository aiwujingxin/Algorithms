package leetcode.problems;

import common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/12 17:01
 */
public class LeetCode1315 {

    public int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (map.get(node) != null && map.get(map.get(node)) != null && map.get(map.get(node)).val % 2 == 0) {
                    sum += node.val;
                }
                if (node.left != null) {
                    map.put(node.left, node);
                    queue.add(node.left);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queue.add(node.right);

                }
            }
        }
        return sum;
    }

}
