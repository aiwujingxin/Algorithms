package leetcode.lists.classic;

/**
 * @author jingxinwu
 * @date 2021-12-05 2:27 下午
 */
public class Number0203 {


    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
