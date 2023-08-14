package leetcode.problems;

import common.TreeNode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/15 18:55
 */
public class LeetCode314 {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<STreeNode> queue = new LinkedList<>();
        Map<Integer, List<STreeNode>> map = new TreeMap<>();
        STreeNode sroot = new STreeNode(root, 0, 0);
        queue.add(sroot);

        List<STreeNode> list = map.getOrDefault(sroot.row, new ArrayList<>());
        list.add(sroot);
        map.put(sroot.row, list);
        while (!queue.isEmpty()) {
            STreeNode node = queue.poll();
            if (node.node.left != null) {
                STreeNode left = new STreeNode(node.node.left, node.row + 1, node.col - 1);
                queue.add(left);
                List<STreeNode> _list = map.getOrDefault(left.col, new ArrayList<>());
                _list.add(left);
                map.put(left.col, _list);
            }
            if (node.node.right != null) {
                STreeNode right = new STreeNode(node.node.right, node.row + 1, node.col + 1);
                queue.add(right);
                List<STreeNode> _list = map.getOrDefault(right.col, new ArrayList<>());
                _list.add(right);
                map.put(right.col, _list);
            }
        }
        List<List<Integer>> lists = new ArrayList<>();
        for (Map.Entry<Integer, List<STreeNode>> entry : map.entrySet()) {
            List<Integer> col = new ArrayList<>();
            for (STreeNode v : entry.getValue()) {
                col.add(v.node.val);
            }
            lists.add(col);
        }
        return lists;
    }

    static class STreeNode {

        public TreeNode node;
        public int row;
        public int col;

        public STreeNode(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
}
