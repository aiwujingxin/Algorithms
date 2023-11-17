package leetcode.problems;

import common.ListNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/17 16:26
 * @link <a href="https://leetcode.com/problems/add-two-numbers-ii/solutions/2645982/java-recursive-solution-95-fast-solution/"></a>
 */

public class LeetCode445_v2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // init
        int len1 = 0, len2 = 0;
        ListNode temp1 = l1, temp2 = l2;
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }

        if (len2 > len1) {
            ListNode t = l1;
            l1 = l2;
            l2 = t;
        }

        ListNode ptr = l1;
        int diff = Math.abs(len1 - len2);
        while (diff != 0) {
            ptr = ptr.next;
            diff--;
        }

        // exec
        int carry = find_carry(ptr, l2);
        if (len1 == len2) {
            if (carry == 0) {
                return l1;
            } else {
                ListNode ans = new ListNode(carry);
                ans.next = l1;
                return ans;
            }
        }
        int lastCarry = carry != 0 ? add_carry(l1, ptr, carry) : 0;
        if (lastCarry == 0) {
            return l1;
        } else {
            ListNode ans = new ListNode(lastCarry);
            ans.next = l1;
            return ans;
        }
    }

    public int find_carry(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return 0;
        }

        int carry = find_carry(l1.next, l2.next);
        int sum = l1.val + l2.val + carry;
        l1.val = sum % 10;
        return sum / 10;
    }

    public int add_carry(ListNode l1, ListNode ptr, int carry) {
        if (l1.next == ptr) {
            int sum = l1.val + carry;
            l1.val = sum % 10;
            return sum / 10;
        } else {
            int carry2 = add_carry(l1.next, ptr, carry);
            int sum = l1.val + carry2;
            l1.val = sum % 10;
            return sum / 10;
        }
    }
}
