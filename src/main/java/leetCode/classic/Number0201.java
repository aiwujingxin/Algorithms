package leetCode.classic;

import java.util.HashSet;

/**
 * @author jingxinwu
 * @date 2021-12-05 1:52 下午
 */
public class Number0201 {

    public ListNode removeDuplicateNodes(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode next = cur.next;

        // 1 2 3 4 5 6
        // c n
        HashSet<Integer> set = new HashSet<>();
        set.add(head.val);

        while (next != null) {
            if (set.contains(next.val)) {
                cur.next = next.next;
                next = cur.next;
            } else {
                set.add(next.val);
                cur = cur.next;
                next = cur.next;
            }
        }
        return dummy.next;

    }

}
