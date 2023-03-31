package leetcode.lists.hot200;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/30 18:15
 */
public class LeetCode426 {


    Node head, pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;

        return head;
    }

    public void dfs(Node cur) {
        if (cur == null) {
            return;
        }

        dfs(cur.left);
        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
