package basic.algorithm.tree.serialize;

import basic.problems.tree.*;
import common.TreeNode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 12:44
 */
public class PostOrder implements Serialization {

    @Override
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return serialize(root.left) + "," + serialize(root.right) + "," + root.val;
    }

    @Override
    public TreeNode deserialize(String data) {
        String[] req = data.split(",");
        ArrayList<String> r = new ArrayList<>(Arrays.asList(req));
        return dfsdeserialize(r);
    }

    public TreeNode dfsdeserialize(ArrayList<String> r) {
        if ("null".equals(r.get(r.size() - 1))) {
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
