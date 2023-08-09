package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/29 14:43
 */
public class LeetCode237 {

    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
