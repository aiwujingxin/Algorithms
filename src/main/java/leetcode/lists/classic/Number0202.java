package leetcode.lists.classic;

/**
 * @author jingxinwu
 * @date 2021-12-05 2:23 下午
 */
public class Number0202 {

    public static void main(String[] args) {



    }

    public int kthToLast(ListNode head, int k) {
        if (head == null) {
            return -1;
        }

        if (head.next == null && k == 1) {
            return head.val;
        }
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        int max = len - k;
        int count = 0;

        ListNode n = head;
        while (count < max) {
            n = n.next;
            count++;
        }
        return n.val;

    }

}
