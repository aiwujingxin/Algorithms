package jove;

/**
 * @author jingxinwu
 * @date 2021-12-23 7:07 PM
 */

import LeetCode.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 第二题： 打印树的左视图
 */
public class Number02 {

    /**
     *  0
     * 1   2
     * 3 4 5 6
     */

    public static void main(String[] args) {

        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(2);

        a.left = b;
        a.right = c;

        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(4);
        b.left = d;
        b.right = e;

        TreeNode f = new TreeNode(5);
        TreeNode g = new TreeNode(6);
        c.left = f;
        c.right = g;
        System.out.println(new Number02().print(a));
    }

    // 1 2
    public List<Integer> print(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        q.add(root);
        level.add(root.val);
        list.add(level);
        while (!q.isEmpty()) {
            int size = q.size();
            level = new ArrayList<>();
            while (size > 0) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                    level.add(node.left.val);
                }
                if (node.right != null) {
                    q.add(node.right);
                    level.add(node.right.val);
                }
                size--;
            }
            if (level.size() != 0) {
                list.add(level);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (List<Integer> n : list) {
            res.add(n.get(0));

        }
        return res;
    }
}
