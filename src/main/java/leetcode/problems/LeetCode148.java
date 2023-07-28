package leetcode.problems;

import common.*;

/**
 * @author jingxinwu
 * @date 2022-02-23 1:37 PM
 */
public class LeetCode148 {


    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        //fix 初始化
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode sorted = head;
        ListNode curr = head.next;

        // 1   2    3    4   5      6      3    xx
        //     pre                 sort   cur

        while (curr != null) {
            //如果都是排好顺序的，则一直往前
            if (sorted.val <= curr.val) {
                sorted = sorted.next;
            } else {

                //从dummy开始
                ListNode pre = dummy;

                while (pre.next.val < curr.val) {
                    pre = pre.next;
                }
                sorted.next = curr.next;
                curr.next = pre.next;
                pre.next = curr;
            }
            curr = sorted.next;
        }

        return dummy.next;
    }
}
