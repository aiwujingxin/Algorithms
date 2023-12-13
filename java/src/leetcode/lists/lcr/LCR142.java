package leetcode.lists.lcr;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 21:53
 */
public class LCR142 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }

        ListNode node = l1.val < l2.val ? l1 : l2;
        node.next = mergeTwoLists(node.next, l1.val >= l2.val ? l1 : l2);
        return node;
    }

}
