package leetcode;

import common.ListNode;

/**
 * @author jingxinwu
 * @date 2021-07-01 11:52 下午
 */
public class LeetCode92 {

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
        System.out.println(leetCode92.reverseBetween(a, 2, 4));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null) {
            return head;
        }

        //[1,  2,   3,   4,   5]
        //2    cur
        //4

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pre = dummy;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode temp = cur.next;
        //  1      2      3      o
        // pre    cur    temp
        for (int i = 0; i < right - left; i++) {
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
            temp = cur.next;
        }
        return dummy.next;
    }

}
