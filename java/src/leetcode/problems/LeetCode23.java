package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 15:57
 */
public class LeetCode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if (l > r) return null;
        if (l == r) return lists[l];
        int m = (l + r) >> 1;
        return mergeTwo(mergeKLists(lists, l, m), mergeKLists(lists, m + 1, r));
    }

    private ListNode mergeTwo(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwo(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwo(l1, l2.next);
            return l2;
        }
    }
}
