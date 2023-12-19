package leetcode.problems;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/19 15:37
 */
public class LeetCode146 {

    class LRUCache {

        HashMap<Integer, Node> map;
        Deque<Node> list;
        int capacity;

        public LRUCache(int capacity) {
            this.map = new HashMap<>();
            this.list = new LinkedList<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
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
            map.put(key, node);
            list.addFirst(node);
        }

        static class Node {
            int key;
            int value;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
