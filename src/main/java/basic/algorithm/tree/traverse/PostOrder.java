package basic.algorithm.tree.traverse;

import basic.problems.tree.Traverse;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 11:50
 */
public abstract class PostOrder implements Traverse {

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
    // 到底进入的左子树，还是进入的右子树，需要记录
    // 如果是右子树，那么就直接把节点弹出来， 不需要再进行访问了
    // 递归记录调用的地址
    @Override
    public List<Integer> Iteration(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;  // 用于记录上一次访问的节点
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                return list;
            }
            // 连续不断的向上一层返回，连续退栈
            cur = stack.pop();
            if (cur.right == null || pre == cur.right) { // 访问节点的条件, 没有右节点了， 或者刚访问完它的右节点
                list.add(cur.val); // 访问
                pre = cur; // 这一步是记录上一次访问的节点
                cur = null; // 此处为了跳过下一次循环的访问左子节点的过程，直接进入栈的弹出阶段，因为但凡在栈中的节点，它们的左子节点都肯定被经过且已放入栈中。
            } else { // 不访问节点的条件
                stack.push(cur); // 将已弹出的根节点放回栈中
                cur = cur.right; // 经过右子节点， 再借助最外层的while循环继续走
            }
        }
        return list;
    }
}
