package leetplan.datastructure.level1;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/11 20:48
 */
public class LeetCode141 {


    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        //一个安全的选择是每次移动慢指针一步，而移动快指针两步。
        // 每一次迭代，快速指针将额外移动一步。
        // 如果环的长度为 M，经过 M 次迭代后，快指针肯定会多绕环一周，并赶上慢指针。
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
