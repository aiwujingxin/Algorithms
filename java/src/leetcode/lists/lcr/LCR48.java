package leetcode.lists.lcr;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/24 10:45
 */
public class LCR48 {

    public class Codec {

        StringBuilder sb = new StringBuilder();

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return sb.toString();
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    sb.append("null");
                }
                sb.append(",");
            }
            System.out.println(sb);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            String[] strings = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int index = 1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (!"null".equals(strings[index])) {
                    node.left = new TreeNode(Integer.parseInt(strings[index]));
                    queue.add(node.left);
                }
                index++;
                if (!"null".equals(strings[index])) {
                    node.right = new TreeNode(Integer.parseInt(strings[index]));
                    queue.add(node.right);
                }
                index++;
            }
            return root;
        }
    }

}
