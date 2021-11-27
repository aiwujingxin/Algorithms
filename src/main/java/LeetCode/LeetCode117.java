package LeetCode;

/**
 * @author jingxinwu
 * @date 2021-07-08 1:43 上午
 */
public class LeetCode117 {

    public Node connect(Node root) {

        if (root == null) {
            return root;
        }

        Node head = null;
        Node pre = null;
        Node cur = root;
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (head == null) {
                        pre = cur.left;
                        head = cur.left;
                    } else {
                        pre.next = cur.left;
                        pre = pre.next;

                    }
                }
                if (cur.right != null) {
                    if (head == null) {
                        pre = cur.right;
                        head = cur.right;
                    } else {
                        pre.next = cur.left;
                        pre = pre.next;
                    }
                }

                cur = cur.next;

            }

            cur = head;
            pre = null;
            head = null;
        }
        return root;
    }

}
