package basic.datastructure.tree.base.traverse;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 12:36
 */
public class PostOrderIteration_double_stack extends PostOrder {

    @Override
    public List<Integer> traverseByIteration(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.empty()) {
            root = stack1.pop();
            stack2.push(root);
            if (root.left != null) {
                stack1.push(root.left);
            }
            if (root.right != null) {
                stack1.push(root.right);
            }
        }
        while (!stack2.empty()) {
            list.add(stack2.pop().val);
        }
        return list;
    }
}
