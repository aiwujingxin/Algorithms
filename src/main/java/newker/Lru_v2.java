package newker;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author jingxinwu
 * @date 2022-02-24 8:43 PM
 */
public class Lru_v2 {

    class LFUCache {

        // 缓存容量
        int capacity;
        Map<Integer, Node> cache;
        TreeSet<Node> sortTree;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>();
            sortTree = new TreeSet<>();
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (!cache.containsKey(key)) {
                if (sortTree.size() == capacity) {
                    // 从哈希表和平衡二叉树中删除最近最少使用的缓存
                    sortTree.remove(sortTree.first().key);
                    cache.remove(sortTree.first());
                }
                // 创建新的缓存
                Node node = new Node(1, key, value);
                // 将新缓存放入哈希表和平衡二叉树中
                cache.put(key, node);
                sortTree.add(node);
            }

            Node cache = this.cache.get(key);
            sortTree.remove(cache);
            cache.cnt += 1;
            cache.value = value;
            sortTree.add(cache);
            this.cache.put(key, cache);
        }
    }

    class Node {

        int cnt;
        int key;
        int value;

        Node(int cnt, int key, int value) {
            this.cnt = cnt;
            this.key = key;
            this.value = value;
        }
    }


}
