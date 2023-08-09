package leetcode.lists.offer;

import common.*;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2021-11-21 10:59 下午
 */
public class Offer35 {

    //https://www.youtube.com/watch?v=UWt3qmjx8qo、
    public Node copyRandomListV2(Node head) {
        //老节点 新节点 的映射
        HashMap<Node, Node> map = new HashMap<>();

        if (head == null) {
            return null;
        }

        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;

        }
        return map.get(head);
    }
}
