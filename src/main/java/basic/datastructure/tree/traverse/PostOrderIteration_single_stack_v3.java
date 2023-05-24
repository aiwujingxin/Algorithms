package basic.datastructure.tree.traverse;

import basic.problems.tree.*;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 12:38
 */
public class PostOrderIteration_single_stack_v3 extends PostOrder implements Traverse {

    @Override
    public List<Integer> traverseByIteration(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode c;
        while (!stack.isEmpty()) {
            c = stack.peek();
            if (c.left != null && root != c.left && root != c.right) {
                stack.push(c.left);
            } else if (c.right != null && root != c.right) {
                stack.push(c.right);
            } else {
                list.add(stack.pop().val);
                root = c;
            }
        }
        return list;
    }
}
