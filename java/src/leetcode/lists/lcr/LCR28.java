package leetcode.lists.lcr;

import common.Node;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/28 21:16
 */
public class LCR28 {

    public Node flatten(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        while (head != null) {
            if (head.child == null) {
                head = head.next;
            } else {
                Node tmp = head.next;
                Node chead = flatten(head.child);
                head.next = chead;
                chead.prev = head;
                head.child = null;
                while (head.next != null) {
                    head = head.next;
                }
                head.next = tmp;
                if (tmp != null) {
                    tmp.prev = head;
                }
                head = tmp;
            }
        }
        return dummy.next;
    }
}
