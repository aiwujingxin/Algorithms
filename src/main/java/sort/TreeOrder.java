package sort;

import common.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author jingxinwu
 * @date 2022-02-17 10:28 PM
 */
public class TreeOrder {


    public static List<Integer> preorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }

    public static List<Integer> inOrder(TreeNode root) {
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

    public List<Integer> postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        TreeNode p = root;
        TreeNode r = null;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.peek();
                if (p.right != null && p.right != r) {
                    p = p.right;
                    stack.push(p);
                    p = p.left;
                } else {
                    p = stack.pop();
                    output.add(p.val);
                    r = p;
                    p = null;
                }
            }
        }
        return output;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new LinkedList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                size--;
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }

}
