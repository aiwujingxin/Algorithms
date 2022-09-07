package leetcode.classic;

/**
 * @author jingxinwu
 * @date 2021-12-05 2:32 下午
 */
public class Number0207 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode qA = headA;
        ListNode qB = headB;
        while (qA != qB) {
            if (qA != null) {
                qA = qA.next;
            } else {
                qA = headB;
            }
            if (qB != null) {
                qB = qB.next;
            } else {
                qB = headA;
            }
        }
        return qA;
    }
}
