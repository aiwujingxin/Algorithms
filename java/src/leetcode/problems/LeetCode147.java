package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/2 13:50
 */
public class LeetCode147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode sorted = head;
        ListNode cur = head.next;
        while (cur != null) {
            //如果都是排好顺序的，则一直往前
            if (sorted.val <= cur.val) {
                sorted = sorted.next;
            } else {
                ListNode pre = dummy;
                // 寻找正确插入的位置
                while (pre.next.val < cur.val) {
                    pre = pre.next;
                }
                sorted.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = sorted.next;
        }
        return dummy.next;
    }
}
