package leetcode.lists.offer;

import common.Node;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/4 15:17
 */
public class Offer36 {
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    // 中序遍历
    void dfs(Node cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);

        //操作root
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;

        dfs(cur.right);
    }
}
