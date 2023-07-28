package leetcode.lists.topinterview;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/6 23:51
 */
public class LeetCode297 {

    //https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74264/Short-and-straight-forward-BFS-Java-code-with-a-queue

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if (Objects.equals(data, "")) {
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
