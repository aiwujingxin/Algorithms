package basic.datastructure.tree.attribute;

import basic.datastructure.tree.Attribute;
import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 12:25
 */
public class Hight implements Attribute {
    @Override
    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(count(root.left), count(root.right)) + 1;
    }
}
