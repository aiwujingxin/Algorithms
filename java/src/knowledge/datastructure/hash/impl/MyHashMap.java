package knowledge.datastructure.hash.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 从零实现哈希表 (拉链法 Separate Chaining)
 * 核心:hash(key) 取模定位桶下标,桶内用链表解决碰撞;装载因子超阈值时扩容 rehash。
 */
public class MyHashMap<K, V> {

    private static class Node<K, V> {
        final K key;
        V val;
        Node<K, V> next;

        Node(K key, V val, Node<K, V> next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    private Node<K, V>[] table;
    private int size;
    private static final double LOAD_FACTOR = 0.75;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = new Node[16];
    }

    private int index(K key) {
        return (key.hashCode() & 0x7fffffff) % table.length;
    }

    public V get(K key) {
        for (Node<K, V> e = table[index(key)]; e != null; e = e.next) {
            if (e.key.equals(key)) return e.val;
        }
        return null;
    }

    public void put(K key, V val) {
        int i = index(key);
        for (Node<K, V> e = table[i]; e != null; e = e.next) {
            if (e.key.equals(key)) {
                e.val = val;
                return;
            }
        }
        table[i] = new Node<>(key, val, table[i]);
        if (++size > table.length * LOAD_FACTOR) resize();
    }

    public void remove(K key) {
        int i = index(key);
        Node<K, V> prev = null, cur = table[i];
        while (cur != null) {
            if (cur.key.equals(key)) {
                if (prev == null) table[i] = cur.next;
                else prev.next = cur.next;
                size--;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        Node<K, V>[] old = table;
        table = new Node[old.length << 1];
        for (Node<K, V> head : old) {
            for (Node<K, V> e = head; e != null; e = e.next) {
                int i = index(e.key);
                table[i] = new Node<>(e.key, e.val, table[i]);
            }
        }
    }
}
