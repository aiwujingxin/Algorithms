package leetcode.lists.LCR;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 21:08
 */
public class LCR31 {
    class LRUCache {
        HashMap<Integer, Node> map;
        LinkedList<Node> list;
        int capacity;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            list = new LinkedList<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.get(key) == null) {
                return -1;
            }
            Node node = map.get(key);
            list.remove(node);
            list.addFirst(node);
            return node.value;
        }

        public void put(int key, int value) {
            // exited
            if (map.get(key) != null) {
                Node node = map.get(key);
                node.value = value;
                list.remove(node);
                list.addFirst(node);
            } else {
                if (map.size() == capacity) {
                    Node node = list.pollLast();
                    map.remove(node.key);
                }
                Node node = new Node(key, value);
                map.put(key, node);
                list.addFirst(node);
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
