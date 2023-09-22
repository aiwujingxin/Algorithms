package leetcode.problems;

import common.ListNode;
import common.TreeNode;

/**
 * @author jingxinwu
 * @date 2021-07-07 12:23 上午
 */
public class LeetCode109 {

    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) {
            return null;
        }
        return helper(head, null);
    }

    private TreeNode helper(ListNode start, ListNode end) {

        if (start == end) {
            return null;
        }
        ListNode slow = start;
        ListNode fast = start;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(start, slow);
        root.right = helper(slow.next, end);
        return root;
    }

}
