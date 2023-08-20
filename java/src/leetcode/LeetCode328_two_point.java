package leetcode;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/4 21:35
 */
public class LeetCode328_two_point {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode even = head.next;
        ListNode second = even;
        while (first.next != null && second.next != null) {
            //删除偶元素
            first.next = first.next.next;
            //移到下一个奇元素
            first = first.next;
            //删除奇元素
            second.next = second.next.next;
            //移到下一个偶元素
            second = second.next;
        }
        //这里first是在奇链尾部，even是偶链
        first.next = even;
        return head;
    }
}
