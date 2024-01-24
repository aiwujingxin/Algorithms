package knowledge.datastructure.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/1 11:50
 */
public class Node {

    public int key;
    public int val;
    public int freq;

    public Node next;
    public Node prev;

    public Set<String> set = new HashSet<>();

    public Node() {
    }

    public Node(int key, int value) {
        this.key = key;
        this.val = value;
    }

    public Node(int freq) {
        this.val = freq;
        this.freq = freq;
    }

    public void add(String key) {
        this.set.add(key);
    }

    public void remove(String key) {
        this.set.remove(key);
    }

    public boolean isEmpty() {
        return this.set.isEmpty();
    }

    public String getValue() {
        return this.set.iterator().next();
    }
}
