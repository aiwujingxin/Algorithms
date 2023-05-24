package basic.datastructure.tree.traverse;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 12:15
 */
public class PreOrderIterationV2 extends PreOrder {

    @Override
    public List<Integer> traverseByIteration(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                list.add(root.val);//visit
                root = root.left;
            }
            root = stack.pop().right;
        }
        return list;
    }
}
