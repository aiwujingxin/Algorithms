package leetcode.lists.offerII;

import common.TreeNode;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/25 17:02
 */
public class Offer53 {


    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if (root == null) {
            return null;
        }
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre == p) {
                return root;
            }
            //fix
            pre = root;
            root = root.right;
        }
        return null;
    }
}
