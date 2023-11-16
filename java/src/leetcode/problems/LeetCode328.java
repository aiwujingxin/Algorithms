package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/16 17:54
 */
public class LeetCode328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode oddDummy = new ListNode();
        ListNode evenDummy = new ListNode();
        ListNode odd = oddDummy;
        ListNode even = evenDummy;

        ListNode cur = head;
        int index = 1;

        while (cur != null) {
            if (index % 2 == 1) {
                odd.next = cur;
                odd = odd.next;
            } else {
                even.next = cur;
                even = even.next;
            }
            index++;
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }

        cur = oddDummy;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = evenDummy.next;
        return oddDummy.next;
    }
}
