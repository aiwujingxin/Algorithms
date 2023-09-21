package basic.datastructure.tree.serialize;

import basic.datastructure.tree.*;
import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 12:44
 */
public class PostOrder {

    public class Codec implements Serialization {

        @Override
        public String serialize(TreeNode root) {
            if (root == null) {
                return NULL;
            }
            return serialize(root.left) + COMMA + serialize(root.right) + COMMA + root.val;
        }

        @Override
        public TreeNode deserialize(String data) {
            String[] req = data.split(COMMA);
            ArrayList<String> r = new ArrayList<>(Arrays.asList(req));
            return dfsdeserialize(r);
        }

        public TreeNode dfsdeserialize(ArrayList<String> r) {
            if (NULL.equals(r.get(r.size() - 1))) {
                r.remove(r.size() - 1);
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(r.get(r.size() - 1)));
            r.remove(r.size() - 1);
            node.right = dfsdeserialize(r);
            node.left = dfsdeserialize(r);
            return node;
        }
    }
}
