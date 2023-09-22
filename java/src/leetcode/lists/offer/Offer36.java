package leetcode.lists.offer;

import common.Node;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 23:36
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

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        // do something
        if (pre != null) {
            pre.right = root;
        } else {
            head = root;
        }
        root.left = pre;
        pre = root;

        dfs(root.right);
    }
}
