package leetcode.lists.lcr;

import common.Node;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 23:34
 */
public class LCR154 {

    HashMap<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (map.containsKey(head)) {
            return map.get(head);
        }

        Node newHead = new Node(head.val);
        map.put(head, newHead);
        newHead.next = copyRandomList(head.next);
        newHead.random = copyRandomList(head.random);
        return newHead;
    }
}
