package leetcode.offer;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/15 09:37
 */
public class Offer37 {


    public class Codec {


        StringBuilder sb = new StringBuilder();

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append("NULL").append(",");
                } else {
                    sb.append(node.val).append(",");
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (sb.isEmpty()) {
                return null;
            }
            String[] strings = sb.toString().split(",");
            TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            nodeQueue.add(root);
            int index = 1;
            while (!nodeQueue.isEmpty()) {
                TreeNode node = nodeQueue.poll();
                if (!Objects.equals(strings[index], "NULL")) {
                    node.left = new TreeNode(Integer.parseInt(strings[index]));
                    nodeQueue.add(node.left);
                }
                index++;
                if (!Objects.equals(strings[index], "NULL")) {
                    node.right = new TreeNode(Integer.parseInt(strings[index]));
                    nodeQueue.add(node.right);
                }
                index++;
            }
            return root;
        }
    }
}
