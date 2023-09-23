package basic.datastructure.tree.attribute;

import basic.datastructure.tree.Attribute;
import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/15 23:12
 */
public class Tilt implements Attribute {

    int ans = 0;

    @Override
    public int count(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sumLeft = dfs(node.left);
        int sumRight = dfs(node.right);
        ans += Math.abs(sumLeft - sumRight);
        return sumLeft + sumRight + node.val;
    }
}