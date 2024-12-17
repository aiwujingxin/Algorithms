package leetcode.problems;

import knowledge.datastructure.list.DoubleLinkedList;
import knowledge.datastructure.list.Node;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/17 12:18
 */
public class LeetCode146 {

    class LRUCache {

        HashMap<Integer, Node> map;
        DoubleLinkedList list;
        int capacity;

        public LRUCache(int capacity) {
            this.map = new HashMap<>();
            this.list = new DoubleLinkedList();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            list.remove(node);
            list.addFirst(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.val = value;
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
    }
}
