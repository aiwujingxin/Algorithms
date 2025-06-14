package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/17 12:18
 */
public class LeetCode146 {

    class LRUCache {

        HashMap<Integer, Node> map;
        MyList list;
        int capacity;

        public LRUCache(int capacity) {
            this.map = new HashMap<>();
            this.list = new MyList();
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            list.remove(node);
            list.addFirst(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                list.remove(node);
                list.addFirst(node);
                return;
            }
            if (map.size() == capacity) {
                Node node = list.removeLast();
                map.remove(node.key);
            }
            Node node = new Node(key, value);
            list.addFirst(node);
            map.put(key, node);
        }

        static class Node {
            public int key;
            public int value;
            Node pre;
            Node next;

            public Node() {
            }

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        static class MyList {
            Node head;
            Node tail;

            MyList() {
                head = new Node();
                tail = new Node();
                head.next = tail;
                tail.pre = head;
            }

            public void remove(Node node) {
                Node pre = node.pre;
                Node next = node.next;
                pre.next = next;
                next.pre = pre;
            }

            public Node removeLast() {
                Node last = tail.pre;
                last.next = tail;
                tail.pre = last.pre;
                remove(last);
                return last;
            }

            public void addFirst(Node node) {
                Node next = head.next;
                node.pre = head;
                head.next = node;
                node.next = next;
                next.pre = node;
            }
        }
    }
}
