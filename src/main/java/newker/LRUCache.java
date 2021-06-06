package newker;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {


    LinkedList<Node> list;
    HashMap<Integer, Node> map;
    private int size;
    private int capacity;

    private class Node {

        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>(capacity);
        this.list = new LinkedList<>();
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }
        list.remove(map.get(key));
        list.addFirst(map.get(key));
        return map.get(key).value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.remove(map.get(key));
            Node node = new Node(key, value);
            map.put(key, node);
            list.addFirst(node);
            return;
        }
        if (list.size() >= capacity) {
            Node node = list.pollLast();
            map.remove(node.key);
            size--;
        }
        Node node = new Node(key, value);
        map.put(key, node);
        list.addFirst(node);
        size++;
    }
}
