package leetcode.problems;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/19 15:37
 */
public class LeetCode146 {

    class LRUCache {

        HashMap<Integer, Node> map = new HashMap<>();
        LinkedList<Node> list = new LinkedList<>();
        int capacity;

        public LRUCache(int capacity) {
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
            Node node = map.get(key);
            if (node != null) {
                node.value = value;
                list.remove(node);
                list.addFirst(node);
            } else {
                if (map.size() >= capacity) {
                    Node r = list.removeLast();
                    map.remove(r.key);
                }
                node = new Node(key, value);
                list.addFirst(node);
                map.put(key, node);
            }
        }

        static class Node {
            public int key;
            public int value;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
