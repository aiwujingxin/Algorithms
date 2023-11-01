package leetcode.problems;

import common.Node;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/1 14:17
 */
public class LeetCode138 {

    HashMap<Node, Node> cache = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (cache.get(head) != null) {
            return cache.get(head);
        }
        Node copyNode = new Node(head.val);
        cache.put(head, copyNode);
        copyNode.next = copyRandomList(head.next);
        copyNode.random = copyRandomList(head.random);
        return cache.get(head);
    }
}
