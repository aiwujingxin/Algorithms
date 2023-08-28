package basicKnowledge.dataStructure.tree.serialize;

import basicKnowledge.dataStructure.tree.Serialization;
import common.TreeNode;

import java.util.LinkedList;
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
                res.append(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                res.append(NULL);
            }
            if (!queue.isEmpty()) {
                res.append(COMMA);
            }
        }
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    @Override
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] dataList = data.substring(1, data.length() - 1).split(COMMA);
        TreeNode root = new TreeNode(Integer.parseInt(dataList[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!NULL.equals(dataList[index])) {
                node.left = new TreeNode(Integer.parseInt(dataList[index]));
                queue.offer(node.left);
            }
            index++;
            if (!NULL.equals(dataList[index])) {
                node.right = new TreeNode(Integer.parseInt(dataList[index]));
                queue.offer(node.right);
            }
            index++;
        }
        return root;
    }
}
