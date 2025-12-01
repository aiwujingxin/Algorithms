package knowledge.datastructure.tree.traverse;

import common.TreeNode;
import knowledge.datastructure.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/14 14:18
 */
public class InOrder implements Tree.Iteration, Tree.DFS {

    List<Integer> list = new ArrayList<>();

    public List<Integer> dfs(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
        return list;
    }

    public List<Integer> iteration(TreeNode root) {
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
