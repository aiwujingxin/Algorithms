package leetcode.lists.topinterview;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/4 20:59
 */
public class LeetCode328 {

    //[2,1,3,5,6,4,7]

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null ||head.next.next == null) {
            return head;
        }

        ListNode tail = head;
        int count = 1;
        while (tail.next != null) {
            tail = tail.next;
            count++;
        }
        int n = count / 2;


        ListNode odd = head;
        ListNode event = head.next;

        int k = 0;

        while (k < n) {
            odd.next = event.next;

            tail.next = event;

            event.next = null;

            odd = odd.next;
            event = odd.next;

            tail = tail.next;

            k++;
        }

        return head;
    }
}
