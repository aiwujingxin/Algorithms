package leetcode.lists.lcr;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 20:56
 */
public class LCR23 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null) {
            return headB;
        }
        if (headB == null) {
            return headA;
        }
        ListNode pa = headA;
        ListNode pb = headB;

        while (pa != pb) {
            pa = pa == null? headB:pa.next;
            pb = pb == null? headA:pb.next;
        }
        return pa;
    }
}
