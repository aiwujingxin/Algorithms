package leetcode.topinterview;

import common.Node;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/25 00:01
 */
public class LeetCode138 {

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}
