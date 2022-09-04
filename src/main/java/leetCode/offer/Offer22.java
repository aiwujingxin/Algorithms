package leetCode.offer;

/**
 * @author jingxinwu
 * @date 2021-11-21 6:07 下午
 */
public class Offer22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        int n = 0;
        ListNode node;
        for (node = head; node != null; node = node.next) {
            n++;
        }
        for (node = head; n > k; n--) {
            node = node.next;
        }
        return node;
    }
}
