package codeTop.ms;

import common.ListNode;

/**
 * @author jingxinwu
 * @date 2022-02-18 11:55 AM
 */
public class LeetCode92 {

    /**
     * @author ronaldwu
     *         输入：head = [1,2,3,4,5], left = 2, right = 4
     *         输出：[1,4,3,2,5]
     **/


    public static void main(String[] args) {
        LeetCode92 leetCode92 = new LeetCode92();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode head = leetCode92.reverseBetween(a, 2, 4);
        System.out.println(head);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pre = dummy;
        //fix find pre
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode workNode = pre.next;
        int count = right - left;

        while (count > 0) {
            ListNode temp = workNode.next.next;
            workNode.next.next = pre.next;

            pre.next = workNode.next;
            workNode.next = temp;
            count--;
        }
        return dummy.next;
    }

}
