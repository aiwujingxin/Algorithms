package leetcode.problems;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jingxinwu
 * @date 2022-03-01 7:14 PM
 */
public class LeetCode662_bfs {

    public int widthOfBinaryTree(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList<>();
        queue.add(new AnnotatedNode(root, 0));
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                AnnotatedNode a = queue.poll();
                level.add(a.col);
                if (a.node.left != null) {
                    queue.add(new AnnotatedNode(a.node.left, a.col * 2));

                }
                if (a.node.right != null) {
                    queue.add(new AnnotatedNode(a.node.right, a.col * 2 + 1));
                }
            }
            ans = Math.max(ans, level.getLast() - level.getFirst() + 1);
        }
        return ans;
    }

    static class AnnotatedNode {

        TreeNode node;
        int col;

        public AnnotatedNode(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
}

