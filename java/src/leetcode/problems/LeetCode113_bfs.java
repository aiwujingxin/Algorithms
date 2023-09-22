package leetcode.problems;

import common.TreeNode;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2021-07-06 12:23 上午
 */
public class LeetCode113_bfs {

    List<List<Integer>> res = new LinkedList<>();
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueSum = new LinkedList<>();
        queueNode.offer(root);
        queueSum.offer(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int rec = queueSum.poll() + node.val;

            if (node.left == null && node.right == null) {
                if (rec == targetSum) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    parentMap.put(node.left, node);
                    queueNode.offer(node.left);
                    queueSum.offer(rec);
                }
                if (node.right != null) {
                    parentMap.put(node.right, node);
                    queueNode.offer(node.right);
                    queueSum.offer(rec);
                }
            }
        }

        return res;
    }

    public void getPath(TreeNode node) {
        List<Integer> list = new LinkedList<>();
        while (node != null) {
            list.add(node.val);
            node = parentMap.get(node);
        }
        Collections.reverse(list);
        res.add(new LinkedList<>(list));
    }
}
