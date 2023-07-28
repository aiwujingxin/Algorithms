package basic.algorithm.tree.traverse;

import basic.problems.tree.*;
import common.*;

import java.util.*;

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
        TreeNode pre = null;  // 用于记录上一次访问的节点
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                if (root.right == null || pre == root.right) { // 访问节点的条件
                    list.add(root.val); // 访问
                    pre = root; // 这一步是记录上一次访问的节点
                    root = null; // 此处为了跳过下一次循环的访问左子节点的过程，直接进入栈的弹出阶段，因为但凡在栈中的节点，它们的左子节点都肯定被经过且已放入栈中。
                } else { // 不访问节点的条件
                    stack.push(root); // 将已弹出的根节点放回栈中
                    root = root.right; // 经过右子节点
                }
            }
        }
        return list;
    }
}
