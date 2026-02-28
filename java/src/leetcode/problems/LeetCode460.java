package leetcode.problems;

import knowledge.datastructure.list.DoubleLinkedList;
import knowledge.datastructure.list.Node;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/30 21:18
 */
public class LeetCode460 {

    class LFUCache {
        HashMap<Integer, DoubleLinkedList> freqMap;
        HashMap<Integer, Node> cache;
        int capacity;
        int minFreq;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.minFreq = 1;
            this.freqMap = new HashMap<>();
            this.cache = new HashMap<>();
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }
            updateFreq(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                node.val = value;
                updateFreq(node);
                return;
            }

            if (cache.size() == capacity) {
                Node del = freqMap.get(minFreq).removeLast();
                cache.remove(del.key);
            }
            Node newNode = new Node(key, value, 1);
            freqMap.computeIfAbsent(1, k -> new DoubleLinkedList()).addFirst(newNode);
            cache.put(key, newNode);
            minFreq = 1;
        }

        private void updateFreq(Node node) {
            int curFreq = node.freq;
            DoubleLinkedList list = freqMap.get(curFreq);
            list.remove(node);
            if (list.isEmpty() && minFreq == curFreq) {
                minFreq++;
            }
            node.freq++;
            freqMap.computeIfAbsent(node.freq, k -> new DoubleLinkedList()).addFirst(node);
        }
    }
}
