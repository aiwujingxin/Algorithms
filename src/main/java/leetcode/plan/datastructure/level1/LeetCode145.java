package leetcode.plan.datastructure.level1;

import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/15 21:54
 * {@link basic.algorithm.tree.traverse.PostOrder}
 */
public class LeetCode145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null;  // 用于记录上一次访问的节点
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            if (!s.isEmpty()) {
                root = s.pop();
                if (root.right == null || pre == root.right) { // 访问节点的条件
                    list.add(root.val); // 访问
                    pre = root; // 这一步是记录上一次访问的节点
                    root = null; // 此处为了跳过下一次循环的访问左子节点的过程，直接进入栈的弹出阶段，因为但凡在栈中的节点，它们的左子节点都肯定被经过且已放入栈中。
                } else { // 不访问节点的条件
                    s.push(root); // 将已弹出的根节点放回栈中
                    root = root.right; // 经过右子节点
                }
            }
        }
        return list;
    }
}
