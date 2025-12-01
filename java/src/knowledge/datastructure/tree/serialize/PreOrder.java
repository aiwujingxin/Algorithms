package knowledge.datastructure.tree.serialize;

import common.TreeNode;
import knowledge.datastructure.tree.Tree;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 12:43
 */
public class PreOrder {

    public class Codec implements Tree.Serialize {

        private int desIndex = 0;
        String COMMA = ",";
        String NULL = "null";

        @Override
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            dfs(sb, root);
            return sb.toString();
        }

        private void dfs(StringBuilder sb, TreeNode root) {
            if (!sb.isEmpty()) {
                sb.append(COMMA);
            }
            // 边界条件
            if (root == null) {
                sb.append(NULL);
                return;
            }
            sb.append(root.val);
            dfs(sb, root.left);
            dfs(sb, root.right);
        }

        // Decodes your encoded data to tree.
        @Override
        public TreeNode deserialize(String data) {
            return decode(data.split(COMMA));
        }

        private TreeNode decode(String[] vals) {
            String val = vals[desIndex++];
            // 边界条件
            if (val.equals(NULL)) {
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = decode(vals);
            node.right = decode(vals);
            return node;
        }
    }
}
