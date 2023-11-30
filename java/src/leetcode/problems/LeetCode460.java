package leetcode.problems;


import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/30 21:18
 * <a href="https://leetcode.com/problems/lfu-cache/solutions/3111658/code-in-java/">code</a>
 * <a href="https://leetcode.cn/problems/lfu-cache/solutions/2457716/tu-jie-yi-zhang-tu-miao-dong-lfupythonja-f56h/">讲解</a>
 */
public class LeetCode460 {

    class LFUCache {

        HashMap<Integer, DoublyLinkedList> freqMap = new HashMap<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int capacity;
        int minFreq;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            minFreq = 1;
        }

        public int get(int key) {
            Node node = getNode(key);
            if (node == null) {
                return -1;
            }
            return node.val;
        }

        public void put(int key, int value) {
            Node node = getNode(key);
            if (node != null) {
                node.val = value;
                return;
            }
            if (map.size() == capacity) {
                Node del = freqMap.get(minFreq).removeLast();
                map.remove(del.key);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            freqMap.computeIfAbsent(1, k -> new DoublyLinkedList()).addFirst(newNode);
            minFreq = 1;
        }

        public Node getNode(int key) {
            if (!map.containsKey(key)) {
                return null;
            }
            Node node = map.get(key);
            freqMap.get(node.freq).remove(node);
            if (freqMap.get(node.freq).isEmpty()) {
                if (minFreq == node.freq) {
                    minFreq = node.freq + 1;
                }
            }
            node.freq++;
            freqMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList()).addFirst(node);
            return node;
        }

        static class Node {
            int key;
            int val;
            Node next;
            Node prev;
            int freq = 1;

            Node(int key, int value) {
                this.key = key;
                this.val = value;
            }
        }

        static class DoublyLinkedList {
            Node head;
            Node tail;

            DoublyLinkedList() {
                head = new Node(-1, -1);
                tail = new Node(-1, -1);
                head.next = tail;
                tail.prev = head;
            }

            void addFirst(Node node) {
                Node next = head.next;

                head.next = node;
                node.prev = head;

                node.next = next;
                next.prev = node;
            }

            Node removeLast() {
                Node node = tail.prev;
                node.prev.next = tail;
                tail.prev = node.prev;
                return node;
            }

            void remove(Node node) {
                Node prev = node.prev;
                Node next = node.next;
                prev.next = next;
                next.prev = prev;
            }

            boolean isEmpty() {
                return head.next == tail;
            }
        }
    }
}
