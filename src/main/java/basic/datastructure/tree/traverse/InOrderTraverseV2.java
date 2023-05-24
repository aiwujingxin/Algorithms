package basic.datastructure.tree.traverse;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 14:17
 */
public class InOrderTraverseV2 extends InOrder {

    @Override
    public List<Integer> traverseByIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                output.add(root.val);
                root = root.right;
            }
        }
        return output;
    }
}
