package leetcode.lists.hot100;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/19 13:38
 */
public class LeetCode160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int len1 = getLen(headA);
        int len2 = getLen(headB);
        ListNode one, two;
        if (len1 < len2) {
            one = headA;
            two = headB;
        } else {
            one = headB;
            two = headA;
        }

        int diff = Math.abs(len1 - len2);

        ListNode a = one;
        ListNode b = two;
        while (diff > 0) {
            b = b.next;
            diff--;
        }

        System.out.println(a.val);
        while (a != null && b != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }

    private int getLen(ListNode headA) {
        int len = 0;
        while (headA != null) {
            len++;
            headA = headA.next;
        }
        return len;

    }
}
