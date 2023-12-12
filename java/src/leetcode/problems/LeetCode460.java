package leetcode.problems;


import basic.datastructure.list.DoubleLinkedList;
import basic.datastructure.list.Node;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/30 21:18
 * <a href="https://leetcode.com/problems/lfu-cache/solutions/3111658/code-in-java/">code</a>
 * <a href="https://leetcode.cn/problems/lfu-cache/solutions/2457716/tu-jie-yi-zhang-tu-miao-dong-lfupythonja-f56h/">讲解</a>
 */
public class LeetCode460 {

    class LFUCache {

        HashMap<Integer, DoubleLinkedList> freqMap = new HashMap<>();
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
            freqMap.computeIfAbsent(1, k -> new DoubleLinkedList()).addFirst(newNode);
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
            freqMap.computeIfAbsent(node.freq, k -> new DoubleLinkedList()).addFirst(node);
            return node;
        }
    }
}
