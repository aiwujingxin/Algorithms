package basic.problems.tree;

import basic.algorithm.tree.serialize.LevelOrder;
import basic.algorithm.tree.util.TreeUtil;
import common.TreeNode;


/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/17 15:21
 */
class SerializationTest {

    public static void main(String[] args) {
        Serialization se = new LevelOrder();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3, new TreeNode(4), new TreeNode(5));
        String str = se.serialize(root);
        System.out.println(str);
        TreeNode tree = se.deserialize(str);
        System.out.println(TreeUtil.isSameTree(root, tree));
    }
}