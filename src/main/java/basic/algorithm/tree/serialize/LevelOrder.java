package basic.algorithm.tree.serialize;

import basic.problems.tree.Serialization;
import common.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;


/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 12:44
 */
public class LevelOrder implements Serialization {
    //https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/solution/297-er-cha-shu-de-xu-lie-hua-yu-fan-xu-l-647c/
    // Encodes a tree to a single string.
    @Override
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        res.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.append("").append(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                res.append("null");
            }
            res.append(",");
        }
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    @Override
    public TreeNode deserialize(String data) {
        if (Objects.equals(data, "")) {
            return null;
        }
        String[] dataList = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataList[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(dataList[i])) {
                node.left = new TreeNode(Integer.parseInt(dataList[i]));
                queue.offer(node.left);
            }
            i++;
            if (!"null".equals(dataList[i])) {
                node.right = new TreeNode(Integer.parseInt(dataList[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}
