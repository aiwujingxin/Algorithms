package leetcode.problems;

import common.ListNode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/10 22:33
 */
public class LeetCode1019 {

    public int[] nextLargerNodes(ListNode head) {
        ListNode cur = head;
        int len = 0;
        HashMap<ListNode, Integer> map = new HashMap<>();
        Stack<ListNode> stack = new Stack<>();
        while (cur != null) {
            while (!stack.isEmpty() && cur.val > stack.peek().val) {
                ListNode node = stack.pop();
                map.put(node, cur.val);
            }
            stack.push(cur);
            cur = cur.next;
            len++;
        }
        cur = head;
        int[] res = new int[len];
        int index = 0;
        while (cur != null) {
            res[index] = map.get(cur) != null ? map.get(cur) : 0;
            index++;
            cur = cur.next;
        }
        return res;
    }
}
