package leetcode.problems;

import common.TreeNode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/16 15:11
 * @see LeetCode863_bfs
 */
public class LeetCode742 {

    HashMap<Integer, List<TreeNode>> graph = new HashMap<>();
    HashMap<Integer, TreeNode> index = new HashMap<>();

    public int findClosestLeaf(TreeNode root, int k) {
        preorder(root);
        //宽度优先遍历队列
        Queue<TreeNode> queue = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int ans = 0;
        //防止重复遍历的visit集合
        Set<TreeNode> visit = new HashSet<>();
        queue.add(index.get(k));
        visit.add(index.get(k));
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    if (node.val != k) {
                        if (level < min) {
                            ans = node.val;
                            min = level;
                        }
                    } else {
                        return node.val;
                    }
                }
                if (graph.containsKey(node.val)) {
                    for (TreeNode n : graph.get(node.val)) {
                        if (!visit.contains(n)) {
                            queue.add(n);
                            visit.add(node);
                        }
                    }
                }
            }
            level++;
        }
        return ans;
    }

    //从根遍历，深度优先搜索找到每个结点的父节点
    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            graph.putIfAbsent(root.val, new ArrayList<>());
            graph.putIfAbsent(root.left.val, new ArrayList<>());
            graph.get(root.val).add(root.left);
            graph.get(root.left.val).add(root);
        }
        if (root.right != null) {
            graph.putIfAbsent(root.val, new ArrayList<>());
            graph.putIfAbsent(root.right.val, new ArrayList<>());
            graph.get(root.val).add(root.right);
            graph.get(root.right.val).add(root);
        }
        index.putIfAbsent(root.val, root);
        preorder(root.left);
        preorder(root.right);
    }
}
