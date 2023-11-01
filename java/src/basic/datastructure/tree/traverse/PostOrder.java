package basic.datastructure.tree.traverse;

import basic.datastructure.tree.Traverse;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 11:50
 */
public class PostOrder implements Traverse {

    List<Integer> list = new ArrayList<>();

    @Override
    public List<Integer> DFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        DFS(root.left);
        DFS(root.right);
        list.add(root.val);
        return list;
    }

    //https://zhuanlan.zhihu.com/p/80578741
    //https://www.youtube.com/watch?v=ZIgudgGOfDs
    // 根节点会两次入栈
    @Override
    public List<Integer> Iteration(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 连续不断的向上一层返回，连续退栈
            cur = stack.pop();
            if (cur.right == null || pre == cur.right) { // 没有右节点,或者刚访问完它的右节点
                list.add(cur.val);
                pre = cur;
                cur = null; // 此处为了跳过下一次循环的访问左子节点的过程，直接进入栈的弹出阶段，因为但凡在栈中的节点，它们的左子节点都肯定被经过且已放入栈中。
            } else {
                stack.push(cur);
                cur = cur.right; // 访问右子树
            }
        }
        return list;
    }
}
