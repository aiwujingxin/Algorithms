package leetcode.lists.lcr;

import common.Node;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/28 21:16
 */
public class LCR29 {

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node in = new Node(insertVal);
            in.next = in;
            return in;
        }
        Node dummy = new Node();
        dummy.next = head;
        Node cur = dummy.next;
        Node pre = dummy;
        while (cur != null) {
            if ((pre != dummy && pre.val <= insertVal) && cur.val >= insertVal) {
                break;
            }
            if (cur.val < pre.val && (cur.val > insertVal || pre.val < insertVal)) {
                break;
            }
            cur = cur.next;
            pre = pre.next;
            if (cur == head) {
                break;
            }
        }
        Node in = new Node(insertVal);
        Node next = pre.next;
        pre.next = in;
        in.next = next;
        return head;
    }
}
