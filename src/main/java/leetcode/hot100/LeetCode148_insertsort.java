package leetcode.hot100;

import common.ListNode;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/12 21:49
 */
public class LeetCode148_insertsort {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
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
                ListNode pre = dummy;
                // 寻找正确插入的位置
                while (pre.next.val < curr.val) {
                    pre = pre.next;
                }
                // 断开 + 插入
                sorted.next = curr.next;
                curr.next = pre.next;
                pre.next = curr;
            }
            curr = sorted.next;
        }
        return dummy.next;
    }
}
