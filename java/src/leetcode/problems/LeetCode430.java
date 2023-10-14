package leetcode.problems;

import common.Node;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/14 15:53
 */
public class LeetCode430 {

    public Node flatten(Node head) {
        Node dummy = new Node();
        dummy.next = head;

        while (head != null) {
            if (head.child == null) {
                head = head.next;
            } else {
                Node tmp = head.next;
                Node cHead = flatten(head.child);
                head.next = cHead;
                cHead.prev = head;
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
