package leetcode;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/17 22:56
 */
public class LeetCode25_v2 {

    public ListNode reverseKGroup(ListNode head, int k) {
        int count = k;

        ListNode end = head;
        // 移动到末尾
        while (count != 0 && end != null) {
            end = end.next;
            count--;
        }

        if (count == 0) {
            end = reverseKGroup(end, k);
            for (int i = 0; i < k; i++) {
                ListNode next = head.next;
                head.next = end;
                end = head;
                head = next;
            }
            head = end;
        }

        return head;
    }
}
