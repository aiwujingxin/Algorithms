package leetcode.problems;


import basic.datastructure.liner.list.DoubleLinkedList;
import basic.datastructure.liner.list.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/30 22:13
 */
public class LeetCode432 {

    class AllOne {

        private final DoubleLinkedList list = new DoubleLinkedList();
        private final Map<String, Node> map = new HashMap<>();

        public void inc(String key) {

            Node node = map.get(key);

            if (node == null) {
                if (list.head.next.freq == 1) {
                    list.head.next.set.add(key);
                    map.put(key, list.head.next);
                } else {
                    Node newNode = new Node(1);
                    newNode.set.add(key);
                    Node next = list.head.next;
                    list.addFront(next, newNode);
                    map.put(key, newNode);
                }
            } else {
                Node next = node.next;
                if (node.next.freq != node.freq + 1) {
                    next = new Node(node.freq + 1);
                    list.addBack(node, next);
                }

                node.set.remove(key);
                next.set.add(key);

                map.put(key, next);
                if (node.set.isEmpty()) {
                    list.remove(node);
                }
            }
        }

        public void dec(String key) {
            if (!map.containsKey(key)) {
                return;
            }

            Node node = map.get(key);
            if (node.freq == 1) {
                node.set.remove(key);
                if (node.set.isEmpty()) {
                    list.remove(node);
                }
                map.remove(key);
                return;
            }

            Node prev = node.prev;
            if (prev.freq + 1 != node.freq) {
                prev = new Node(node.freq - 1);
                list.addFront(node, prev);
            }

            node.set.remove(key);
            prev.set.add(key);

            if (node.set.isEmpty()) {
                list.remove(node);
            }

            map.put(key, prev);
        }

        public String getMaxKey() {
            return list.head.next == list.tail ? "" : list.tail.prev.set.iterator().next();
        }

        public String getMinKey() {
            return list.head.next == list.tail ? "" : list.head.next.set.iterator().next();
        }
    }
}
