package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/17 12:18
 */
public class LeetCode146 {

    class LRUCache {

        HashMap<Integer, Node> cache;
        DoubleList list;
        int capacity;

        public LRUCache(int capacity) {
            this.cache = new HashMap<>();
            this.list = new DoubleList();
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) return -1;
            list.remove(node);
            list.addFirst(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                node.val = value;
                list.remove(node);
                list.addFirst(node);
                return;
            }
            if (cache.size() == capacity) {
                Node del = list.removeLast();
                cache.remove(del.key);
            }
            Node newNode = new Node(key, value);
            list.addFirst(newNode);
            cache.put(key, newNode);
        }

        static class Node {
            int key;
            int val;
            Node pre;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.val = value;
            }
        }

        static class DoubleList {
            Node head;
            Node tail;

            public DoubleList() {
                head = new Node(-1, -1);
                tail = new Node(-1, -1);
                head.next = tail;
                tail.pre = head;
            }

            public Node removeLast() {
                Node last = tail.pre;
                remove(last);
                return last;
            }

            public void remove(Node node) {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }

            public void addFirst(Node node) {
                node.next = head.next;
                node.pre = head;
                head.next = node;
                node.next.pre = node;
            }
        }
    }
}
