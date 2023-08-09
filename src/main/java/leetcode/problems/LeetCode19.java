package leetcode.problems;

import common.*;

/**
 * @author jingxinwu
 * @date 2021-06-16 10:56 下午
 */
public class LeetCode19 {


    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null || head.next == null) {
            return head;
        }

        // 1 2 3 4 5
        int length = 0;
        ListNode count = head;
        while (count != null) {
            length++;
            count = count.next;
        }
        System.out.println(length);

        int diff = length - n;
        System.out.println(diff);

        ListNode cur = head;
        while (diff > 1) {
            cur = cur.next;
            diff--;
        }

        cur.next = cur.next.next;

        return head;
    }

    public ListNode removeNthFromEndV2(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}


