package knowledge.datastructure.tree.traverse;

import common.TreeNode;
import knowledge.datastructure.tree.DFS;
import knowledge.datastructure.tree.Iteration;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 14:18
 */
public class InOrder implements Iteration, DFS {


    List<Integer> list = new ArrayList<>();

    @Override
    public List<Integer> DFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        DFS(root.left);
        list.add(root.val);
        DFS(root.right);
        return list;
    }

    @Override
    public List<Integer> Iteration(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
