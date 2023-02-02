package basic.datastructure.tree.base.build;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/15 23:41
 */
public interface BuildTree {

    TreeNode buildTree(int[] preorder, int[] inorder);
}
