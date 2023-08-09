package basic.algorithm.tree.traverse;

import basic.structure.tree.*;
import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 11:47
 */
public class PreOrder implements Traverse {

    List<Integer> list = new ArrayList<>();

    @Override
    public List<Integer> DFS(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        list.add(root.val);
        DFS(root.left);
        DFS(root.right);
        return list;
    }

    @Override
    public List<Integer> Iteration(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                list.add(root.val);//visit
                stack.push(root);
                root = root.left;
            }
            // 模拟退栈过程
            root = stack.pop();
            root = root.right;
        }
        return list;
    }
}