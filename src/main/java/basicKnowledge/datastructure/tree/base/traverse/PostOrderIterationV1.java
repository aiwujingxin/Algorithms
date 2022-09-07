package basicKnowledge.datastructure.tree.base.traverse;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 12:52
 */
public class PostOrderIterationV1 extends PostOrder implements Traverse {


    @Override
    public List<Integer> traverseByIteration(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode r = null;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.peek();
                if (p.right != null && p.right != r) {
                    p = p.right;
                    stack.push(p);
                    p = p.left;
                } else {
                    p = stack.pop();
                    list.add(p.val);
                    r = p;
                    p = null;
                }
            }
        }
        return list;
    }
}

