package knowledge.datastructure.tree.traverse;

import common.TreeNode;
import knowledge.datastructure.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 11:50
 * <a href="https://zhuanlan.zhihu.com/p/80578741"></a>
 */
public class PostOrder implements Tree.Iteration, Tree.DFS {

    List<Integer> list = new ArrayList<>();

    public List<Integer> dfs(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        dfs(root.left);
        dfs(root.right);
        list.add(root.val);
        return list;
    }

    public List<Integer> iteration(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == pre) { // 可以访问根节点: 没有右节点,或者刚访问完它的右节点
                list.add(root.val);
                pre = root;
                root = null; // 此处为了跳过下一次循环的访问左子节点的过程，直接进入栈的弹出阶段。
            } else {
                stack.push(root);// 根节点会两次入栈
                root = root.right;// 访问右子树
            }
        }
        return list;
    }
}
