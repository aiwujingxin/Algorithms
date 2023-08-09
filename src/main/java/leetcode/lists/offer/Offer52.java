package leetcode.lists.offer;

import common.*;

/**
 * @author jingxinwu
 * @date 2021-11-24 12:57 上午
 */
public class Offer52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;

        ListNode pA = headA;
        ListNode pB = headB;

        // 先获取两个链表的长度
        while (pA != null) {
            pA = pA.next;
            lengthA++;
        }
        while (pB != null) {
            pB = pB.next;
            lengthB++;
        }

        // 计算链表长度差n，将长的链表先走n步
        int n = lengthA > lengthB ? lengthA - lengthB : lengthB - lengthA;
        while (lengthA > lengthB && n > 0) {
            headA = headA.next;
            n--;
        }
        while (lengthB > lengthA && n > 0) {
            headB = headB.next;
            n--;
        }

        // 然后两个链表才开始同时一起走
        // 知道两个节点相等 或者 都为null的时候结束循环
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}
