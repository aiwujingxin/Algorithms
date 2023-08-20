package leetcode.offer;

import java.util.Stack;

import common.ListNode;

/**
 * @author jingxinwu
 * @date 2021-11-19 9:28 下午
 */
public class Offer6 {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[] {};
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode point = head;
        while (point != null) {
            stack.push(point);
            point = point.next;
        }
        int[] arr = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            arr[index] = stack.pop().val;
            index++;
        }
        return arr;
    }
}
