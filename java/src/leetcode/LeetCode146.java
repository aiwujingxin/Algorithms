package leetcode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/20 22:34
 */
public class LeetCode146 {

    class LRUCache {

        LinkedList<Node> list;
        HashMap<Integer, Node> map;
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.list = new LinkedList<>();
            this.map = new HashMap<>();
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
            if (node != null) { //if exited
                node.value = value;
                list.remove(node);
                list.addFirst(node);
            } else {
                // 超过capacity
                if (map.size() == capacity) {
                    Node remove = list.pollLast();
                    map.remove(remove.key);
                    node = new Node(key, value);
                    list.addFirst(node);
                    map.put(key, node);
                } else {
                    node = new Node(key, value);
                    map.put(key, node);
                    list.addFirst(node);
                }
            }
        }

        static class Node {
            public int value;
            public int key;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }


}

