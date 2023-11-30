package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/30 18:58
 */

public class LeetCode432 {

    class AllOne {

        private final Map<String, Node> map;
        private final Node head;
        private final Node tail;

        public AllOne() {
            map = new HashMap<>();
            head = new Node(0, "");
            tail = new Node(0, "");
            head.next = tail;
            tail.pre = head;
        }

        public void inc(String key) {
            Node node = map.get(key);
            if (node == null) {
                // 插入头部
                node = new Node(1, key);
                insertNode(head, node, head.next);
                map.put(key, node);
            } else {
                // 向后移动
                node.count += 1;
                Node temp = node.next;
                while (temp != tail && temp.count < node.count) {
                    temp = temp.next;
                }
                //  temp为tail或者第一个大于等于node的节点
                //  第一步，将node从当前位置移除
                removeNode(node);
                //  第二步，将node插入temp之前
                insertNode(temp.pre, node, temp);
            }

        }

        public void dec(String key) {
            Node node = map.get(key);
            if (node != null) {
                node.count = node.count - 1;
                if (node.count == 0) {
                    removeNode(node);
                    map.remove(key);
                } else {
                    Node temp = node.pre;
                    while (temp != head && node.count < temp.count) {
                        temp = temp.pre;
                    }
                    removeNode(node);
                    insertNode(temp, node, temp.next);
                }
            }
        }

        public String getMaxKey() {
            return tail.pre == head ? "" : tail.pre.val;
        }

        public String getMinKey() {
            return head.next == tail ? "" : head.next.val;
        }

        private void removeNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.pre = null;
            node.next = null;
        }

        private void insertNode(Node pre, Node node, Node next) {
            node.pre = pre;
            node.next = next;

            pre.next = node;
            next.pre = node;
        }

        static class Node {
            public Node(Integer count, String val) {
                this.val = val;
                this.count = count;
            }

            Integer count;
            String val;
            Node pre;
            Node next;
        }
    }
}