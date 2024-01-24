package leetcode.problems;



import knowledge.datastructure.linkedlist.DoubleLinkedList;
import knowledge.datastructure.linkedlist.Node;

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
                if (!list.isEmpty() && list.getFirst().freq == 1) {
                    list.getFirst().add(key);
                    map.put(key, list.getFirst());
                } else {
                    Node newNode = new Node(1);
                    newNode.add(key);
                    list.addFirst(newNode);
                    map.put(key, newNode);
                }
                return;
            }
            Node next = node.next;
            if (node.next.freq != node.freq + 1) {
                next = new Node(node.freq + 1);
                list.addBack(node, next);
            }
            node.remove(key);
            next.add(key);
            map.put(key, next);
            if (node.isEmpty()) {
                list.remove(node);
            }
        }

        public void dec(String key) {
            if (!map.containsKey(key)) {
                return;
            }

            Node node = map.get(key);
            if (node.freq == 1) {
                node.remove(key);
                if (node.isEmpty()) {
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

            node.remove(key);
            prev.add(key);

            if (node.isEmpty()) {
                list.remove(node);
            }

            map.put(key, prev);
        }

        public String getMaxKey() {
            return list.isEmpty() ? "" : list.getLast().getValue();
        }

        public String getMinKey() {
            return list.isEmpty() ? "" : list.getFirst().getValue();
        }
    }
}
