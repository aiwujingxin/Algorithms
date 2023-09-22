package leetcode.lists.offer;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 21:39
 */
public class Offer22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        while (k-- > 0) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (fast != null) {
            cur = cur.next;
            fast = fast.next;
        }
        return cur.next;
    }
}
