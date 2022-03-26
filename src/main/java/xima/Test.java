package xima;

import common.TreeNode;

/**
 * @author jingxinwu
 * @date 2022-02-25 5:07 PM
 */
public class Test {

    public int cal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(cal(root.right), cal(root.left)) + 1;
    }

}
