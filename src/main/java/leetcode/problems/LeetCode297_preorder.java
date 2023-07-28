package leetcode.problems;

import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/7 00:06
 */
public class LeetCode297_preorder {


    //https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/2332009/Java-Easy-Pre-Order
    public static class Codec {
        final String spliter = ",";
        final String nan = "X";

        StringBuilder data;

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            data = new StringBuilder();
            if (root == null) {
                return data.toString();
            }

            buildString(root);
            System.out.println(data);
            return data.toString();
        }

        void buildString(TreeNode root) {
            if (root == null) {
                data.append(nan).append(spliter);
                return;
            }
            data.append(root.val).append(spliter);
            buildString(root.left);
            buildString(root.right);
        }

        Queue<String> nodes;

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("")) return null;
            nodes = new LinkedList<>();
            nodes.addAll(Arrays.asList(data.split(spliter)));
            return buildTree();
        }

        TreeNode buildTree() {
            String val = nodes.poll();
            assert val != null;
            if (val.equals(nan)) {
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree();
            node.right = buildTree();
            return node;
        }
    }
}
