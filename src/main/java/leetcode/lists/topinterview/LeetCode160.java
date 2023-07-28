package leetcode.lists.topinterview;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/25 00:07
 */
public class LeetCode160 {

    //https://www.jiakaobo.com/leetcode/160.%20Intersection%20of%20Two%20Linked%20Lists.html

    //  [4,1,8,4,5]
    //[5,6,1,8,4,5]
    //study
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}
