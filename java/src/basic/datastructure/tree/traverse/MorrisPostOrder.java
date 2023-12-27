package basic.datastructure.tree.traverse;

import basic.datastructure.tree.TraverseIteration;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/27 21:48
 */
public class MorrisPostOrder implements TraverseIteration {

    List<Integer> list = new ArrayList<>();

    public List<Integer> Iteration(TreeNode head) {
        if (head == null) {
            return new ArrayList<>();
        }
        TreeNode cur = head;
        TreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(head);

        return list;
    }

    public void printEdge(TreeNode node) {
        TreeNode tail = reverseEdge(node);
        TreeNode cur = tail;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    public TreeNode reverseEdge(TreeNode node) {
        TreeNode pre = null;
        TreeNode next = null;
        while (node != null) {
            next = node.right;
            node.right = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
