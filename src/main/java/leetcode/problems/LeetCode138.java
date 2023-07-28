package leetcode.problems;

import common.*;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2022-02-17 12:55 PM
 */

public class LeetCode138 {

    HashMap<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        if (map.containsKey(head)) {
            return map.get(head);
        }

        Node node = new Node(head.val);

        //fix
        map.put(head, node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }

}
