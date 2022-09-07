package leetcode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/17 21:47
 */
public class LeetCode623 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode q = new TreeNode(2);
        TreeNode w = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        root.left = q;
        root.right = w;
        q.left = e;
        System.out.println(new LeetCode623().addOneRow(root, 5, 4));
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) {
            return root;
        }
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        if (depth == 2) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = new TreeNode(val);
            root.right = new TreeNode(val);
            root.left.left = left;
            root.right.right = right;
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelNum = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> level = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    level.add(node.left);
                    queue.add(node.left);
                }
                if (node.right != null) {
                    level.add(node.right);
                    queue.add(node.right);
                }
                size--;
            }
            print(level);
            levelNum++;
            if (levelNum + 1 == depth) {
                for (TreeNode treeNode : level) {
                    TreeNode left = treeNode.left;
                    TreeNode right = treeNode.right;
                    treeNode.left = new TreeNode(val);
                    treeNode.right = new TreeNode(val);
                    treeNode.left.left = left;
                    treeNode.right.right = right;
                }
                return root;
            }
        }
        return root;
    }

    public void print(List<TreeNode> list) {
        for (TreeNode n : list) {
            System.out.print(n.val);
        }
        System.out.print("===");
    }
}
