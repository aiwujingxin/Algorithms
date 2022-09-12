package leetcode.hot100;

import common.ListNode;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/9/11 23:43
 */
public class LeetCode234 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        new LeetCode234().print_values_in_reverse(node);
    }

    private ListNode frontPointer;

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }


    private void print_values_in_reverse(ListNode head) {
        if (head != null) {
            print_values_in_reverse(head.next);
            System.out.println(head.val);
        }
    }
}
