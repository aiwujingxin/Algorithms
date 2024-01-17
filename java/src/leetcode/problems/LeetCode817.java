package leetcode.problems;

import common.ListNode;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/17 23:06
 */
public class LeetCode817 {

    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            if (!set.contains(cur.val)) {
                cur = cur.next;
            } else {
                ListNode t = cur.next;
                while (t != null && set.contains(t.val)) {
                    t = t.next;
                }
                count++;
                cur = t;
            }
        }
        return count;
    }
}
