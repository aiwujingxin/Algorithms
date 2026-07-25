package knowledge.algorithms.twopoint.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 循环/环检测模板 (Cycle Detection Template)
 * 利用快慢指针检测链表或数组状态转移中是否存在环，即 Floyd 判圈算法。
 */
public class CycleDetection {

    /**
     * 链表节点定义
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 检测是否存在环，并返回入环的第一个节点
     *
     * @param head 链表头节点
     * @return 环的入口节点，无环则返回 null
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // 步骤1：判断是否有环
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        // 如果没有环，返回 null
        if (!hasCycle) {
            return null;
        }

        // 步骤2：寻找环的入口
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
