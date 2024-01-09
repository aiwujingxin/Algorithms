package knowledge.datastructure.tree.serialize;

import common.TreeNode;
import knowledge.datastructure.tree.Serialization;
import leetcode.problems.LeetCode449;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/16 15:52
 * @see LeetCode449
 */
public class BSTCodec {

    public class Codec implements Serialization {

        String COMMA = ",";

        public String serialize(TreeNode root) {
            if (root == null) {
                return null;
            }
            List<String> list = new ArrayList<>();
            preOrder(root, list);
            int n = list.size();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(list.get(i));
                if (i != n - 1) {
                    sb.append(COMMA);
                }
            }
            return sb.toString();
        }

        void preOrder(TreeNode root, List<String> list) {
            if (root == null) {
                return;
            }
            list.add(String.valueOf(root.val));
            preOrder(root.left, list);
            preOrder(root.right, list);
        }

        public TreeNode deserialize(String s) {
            if (s == null) {
                return null;
            }
            String[] list = s.split(",");
            return buildTree(list, 0, list.length - 1);
        }

        TreeNode buildTree(String[] list, int start, int end) {
            if (start > end) {
                return null;
            }
            int val = Integer.parseInt(list[start]);
            int left = start + 1, right = end;
            while (left < right) {
                int mid = (left + right) / 2;
                if (Integer.parseInt(list[mid]) > val) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            TreeNode root = new TreeNode(val);
            if (left == list.length) {
                return root;
            }
            if (Integer.parseInt(list[left]) <= val) {
                left++;
            }
            root.left = buildTree(list, start + 1, left - 1);
            root.right = buildTree(list, left, end);
            return root;
        }
    }
}
